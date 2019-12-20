package org.study.llf.oauth2.res.config.res;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.boot.autoconfigure.security.oauth2.authserver.AuthorizationServerProperties;

import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-11-15
 * Time 9:19
 */
@Configuration
@EnableResourceServer
@Order(6)

public   class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    private static final String DEMO_RESOURCE_ID = "llorder";
    @Autowired
    private ResourceServerProperties resourceServerProperties;
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(DEMO_RESOURCE_ID).stateless(true);
//        resources.tokenServices(tokenServices());
        resources.tokenStore(tokenStore());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                // Since we want the protected resources to be accessible in the UI as well we need
                // session creation to be allowed (it's disabled by default in 2.0.6)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .requestMatchers().anyRequest()
                .and()
                .anonymous()
                .and()
                .authorizeRequests()
//                    .antMatchers("/product/**").access("#oauth2.hasScope('select') and hasRole('ROLE_USER')")
                .antMatchers("/product/**").authenticated()
                .antMatchers("/order/**").authenticated();//配置order访问控制，必须认证过后才可以访问
        // @formatter:on
    }


    /**
     * 资源服务器若和授权服务器不在同一jvm,则需告诉资源服务器令牌如何存储与解析，并与授权服务器使用相同的密钥进行解密
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(name={"tokenStore"})
    public TokenStore tokenStore() {
        System.out.println("@ConditionalOnMissingBean(name={\"tokenStore\"})");
        return new JwtTokenStore(jwtAccessTokenConverter());
    }
    /**令牌解析方式一（JWT 对称加密）
     * 资源服务器若和授权服务器不在同一jvm,则需告诉资源服务器令牌如何存储与解析，并与授权服务器使用相同的密钥进行解密
     * 与授权服务器使用共同的密钥进行解析
     * @return
     */
//    @Bean
//    @ConditionalOnMissingBean(name={"jwtAccessTokenConverter"})
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        System.out.println("@ConditionalOnMissingBean(name={\"jwtAccessTokenConverter\"})");
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setSigningKey("123");
//        return converter;
//    }


    /**
     * 令牌解析方式二（JWT 非对称加密）
     * 非对称加密需要公钥，可以从本地获取，也可以从授权服务器提供的公钥端点获取
     * 若本地获取不到公钥资源文件 pubkey.txt 则从授权服务器端点获取
     * @return
     */

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        //设置用于解码的非对称加密的公钥
        converter.setVerifierKey(getPubKey());
        return converter;
    }
    /**
     * 非对称加密,本地公钥 pubkey.txt
     * @return
     */
    private String getPubKey() {
        org.springframework.core.io.Resource resource = new ClassPathResource("pubkey.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            return br.lines().collect(Collectors.joining("\n"));
        } catch (IOException ioe) {
            return getKeyFromAuthorizationServer();
        }
    }
    /**
     * 非对称加密
     * @return
     */
    private String getKeyFromAuthorizationServer() {
        ObjectMapper objectMapper = new ObjectMapper();
        String pubKey = new RestTemplate().getForObject(resourceServerProperties.getJwt().getKeyUri(), String.class);
        try {
            Map map = objectMapper.readValue(pubKey, Map.class);
            System.out.println("联网公钥");
            return map.get("value").toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 令牌解析方式三（通过访问授权服务器解析令牌-适用 JDBC、内存存储）
     * 资源服务器通过访问授权服务器 /oauth/check_token 端点解析令牌需要使用 RemoteTokenServices
     * 并且使用 DefaultAccessTokenConverter 来实现令牌数据的存储
     * @return OAuth2ClientProperties
     */
//    @Autowired
//    private OAuth2ClientProperties oAuth2ClientProperties;
//
//    @Resource(name="authServerProp")
////    @Autowired
//    private AuthorizationServerProperties authorizationServerProperties;
//    @Bean
//    public ResourceServerTokenServices tokenServices() {
//        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
//        remoteTokenServices.setCheckTokenEndpointUrl(authorizationServerProperties.getCheckTokenAccess());
//        remoteTokenServices.setClientId(oAuth2ClientProperties.getClientId());
//        remoteTokenServices.setClientSecret(oAuth2ClientProperties.getClientSecret());
//        remoteTokenServices.setAccessTokenConverter(accessTokenConverter());
//        return remoteTokenServices;
//    }
//    @Bean
//    public AccessTokenConverter accessTokenConverter() {
//        return new DefaultAccessTokenConverter();
//    }

}
