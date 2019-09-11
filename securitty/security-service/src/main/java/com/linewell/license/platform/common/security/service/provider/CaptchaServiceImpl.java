//package com.linewell.license.platform.common.security.service.provider;
//
//
//import com.linewell.license.platform.common.security.facade.api.CaptchaService;
//import com.linewell.license.platform.common.security.facade.constants.SecurityConstants;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//
///**
// * 验证码校验
// *
// * @author luolifeng
// * @version 1.0.0
// * Date 2019-08-13
// * Time 9:08
// */
//@Service
//public class CaptchaServiceImpl implements CaptchaService {
//
//    @Value("${license.security.captcha.disable:false}")
//    private boolean isCaptchaDisable;
//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;
//
//    @Override
//    public boolean captchaValidate(String captchaId, String captchaText)  {
//
//        if (!isCaptchaDisable) {
//            String captcha = redisTemplate.opsForValue().get(SecurityConstants.REDIS_CAPTCHA + captchaId);
//            if (StringUtils.isEmpty(captcha)) {
//                throw new  RuntimeException("验证码不正确");
//            }
//            return captcha.equalsIgnoreCase(captchaText);
//        }
//        return true;
//
//    }
//
//}
