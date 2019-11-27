package org.study.llf.oauth2.config.server;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * 令牌增强器，自定义内容
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-11-27
 * Time 15:55
 */
public class CustomTokenEnhancer implements TokenEnhancer {

    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken,OAuth2Authentication authentication) {
        Map<String, Object> additionalInfo = new HashMap<String, Object>(16);
        additionalInfo.put("organization", authentication.getName() );
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
