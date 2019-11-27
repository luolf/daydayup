package org.study.llf.oauth2.config.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.*;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-11-15
 * Time 10:08
 */
@Configuration
@EnableAuthorizationServer
@Order(5)
public  class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    RedisConnectionFactory redisConnectionFactory;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private DataSource dataSource;

    @Autowired
    private TokenStore tokenStore;



    @Bean // 声明 ClientDetails实现
    public ClientDetailsService clientDetails() {
        return new JdbcClientDetailsService(dataSource);
    }
    @Autowired
    UserDetailsService userDetailsService;
    private static final String DEMO_RESOURCE_ID = "order";
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //配置两个客户端,一个用于password认证一个用于client认证
//        clients.inMemory().withClient("client_1")
//                .resourceIds(DEMO_RESOURCE_ID)
//                .authorizedGrantTypes("client_credentials", "refresh_token")
//                .scopes("select")
//                .authorities("client")
//                .secret(this.passwordEncoder.encode("123456"))
//                .and().withClient("client_2")
//                .resourceIds(DEMO_RESOURCE_ID)
//                .authorizedGrantTypes("password", "refresh_token")
//                .scopes("select")
//                .authorities("client")
//                .secret(this.passwordEncoder.encode("123456"));
        System.out.println(this.passwordEncoder.encode("123456"));
        clients.withClientDetails(clientDetails());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(
                Arrays.asList(tokenEnhancer(), jwtAccessTokenConverter()));
//内存中存放
//        endpoints
//                .tokenStore(new RedisTokenStore(redisConnectionFactory))
//                .tokenStore(new InMemoryTokenStore())
//                .authenticationManager(authenticationManager)
//                .userDetailsService(userDetailsService)
//                // 2018-4-3 增加配置，允许 GET、POST 请求获取 token，即访问端点：oauth/token
//                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);



// 数据库中存放




        endpoints.authenticationManager(authenticationManager);
        //告诉Spring Security Token的生成方式accessTokenConverter(jwtAccessTokenConverter())
        endpoints.tokenStore(tokenStore).tokenEnhancer(tokenEnhancerChain);
//
//        // 配置TokenServices参数
//        DefaultTokenServices tokenServices = new DefaultTokenServices();
//        tokenServices.setTokenStore(endpoints.getTokenStore());
//        tokenServices.setSupportRefreshToken(false);
//        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
//        tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
//        //30天
//        tokenServices.setAccessTokenValiditySeconds( (int) TimeUnit.DAYS.toSeconds(30));
//        endpoints.tokenServices(tokenServices);
//
//        endpoints.reuseRefreshTokens(true);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        //允许表单认证
//        oauthServer.allowFormAuthenticationForClients();

        oauthServer
                //允许所有资源服务器访问公钥端点（/oauth/token_key）
                //只允许验证用户访问令牌解析端点（/oauth/check_token）
                .tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()")
                // 允许客户端发送表单来进行权限认证来获取令牌
                .allowFormAuthenticationForClients();
    }

//    @Bean // 声明TokenStore实现
//    public TokenStore tokenStore() {
//        return new JdbcTokenStore(dataSource);
//    }
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }
    //使用同一个密钥来编码 JWT 中的  OAuth2 令牌
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        String secret="123";
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(secret);
        return converter;
    }
//    @Bean
//    //使用非对称加密的私钥编码 JWT 中的  OAuth2 令牌
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("mytest.jks"), "mypass".toCharArray());
//        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("mytest"));
//        return converter;
//    }
    @Bean
    public TokenEnhancer tokenEnhancer() {
        return new CustomTokenEnhancer();
    }
}