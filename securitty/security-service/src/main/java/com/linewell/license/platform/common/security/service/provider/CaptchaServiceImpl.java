package com.linewell.license.platform.common.security.service.provider;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class CaptchaServiceImpl implements CaptchaService {
    @Value("${captcha.disable:false}")
    private boolean captchaDisable;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean captchaValidate(String captchaID, String inputCaptcha)  {
        // 没有禁用验证码，则开始验证用户输入的验证码
        if (!captchaDisable) {
            String captcha = redisTemplate.opsForValue().get(SysMgrConstants.REDIS_CAPTCHA + captchaID);
            if (StringUtils.isEmpty(captcha)) {
                throw new  Exception( );
            }
            return captcha.equalsIgnoreCase(inputCaptcha);
        }
        return true;

    }

    @Override
    public boolean captchaValidate(LoginInfoVO loginInfoVO)   {
        return this.captchaValidate(loginInfoVO.getCaptchaID(), loginInfoVO.getCaptcha());

    }

}
