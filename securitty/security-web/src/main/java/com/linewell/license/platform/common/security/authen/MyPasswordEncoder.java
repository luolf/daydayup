package com.linewell.license.platform.common.security.authen;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
//        return SecurityMd5Util.encode((String) charSequence);
        return (String)charSequence;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {

        String encodeResult = (String) rawPassword;
        return encodedPassword.equals(encodeResult);
    }

}
