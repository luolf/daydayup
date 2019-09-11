package com.linewell.license.platform.common.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 加密解密
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-21
 * Time 10:34
 */
@Component("myPasswordEncoder")
public class MyPasswordEncoderConfig implements PasswordEncoder {

    @Autowired
    SecurityConfigBean securityConfigBean;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);

    @Override
    public String encode(CharSequence charSequence) {
        return bCryptPasswordEncoder.encode(charSequence);
    }

    @Override
    public boolean matches(CharSequence charSequence, String encodedPassword) {
        return bCryptPasswordEncoder.matches(charSequence, encodedPassword);
    }
}
