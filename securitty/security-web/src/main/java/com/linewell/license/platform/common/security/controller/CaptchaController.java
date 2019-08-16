package com.linewell.license.platform.common.security.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.linewell.license.platform.common.security.facade.api.CaptchaService;
import com.linewell.license.platform.common.security.facade.constants.SecurityConstants;
import com.linewell.license.platform.common.security.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 验证码获取和验证
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-13
 * Time 9:08
 */
@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, value = "/auth/captcha")
public class CaptchaController {

    @Autowired
    private DefaultKaptcha captchaProducer;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    CaptchaService captchaService;
    @Value("${license.security.captcha.timeout}")
    private   Integer TIMEOUT;

    /**
     * 获取验证码图片
     * @param response
     * @throws Exception
     */
    @RequestMapping("/fetch")
    public void getKaptchaImage( HttpServletResponse response) throws IOException {
        String uuid = UUIDUtil.getUUID();
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Captcha-ID", uuid);
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        // 生成验证码
        String capText = captchaProducer.createText();

        redisTemplate.opsForValue().set(SecurityConstants.REDIS_CAPTCHA + uuid, capText, TIMEOUT, TimeUnit.MINUTES);

        // 向客户端写出
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }

    /**
     * 验证码校验
     * @param captchaId 验证码id
     * @param captchaText 验证码
     * @return Boolean

     */
    @GetMapping("/validate")
    public Boolean captchaValidate(String captchaId, String captchaText)
    {
        return captchaService.captchaValidate(captchaId,captchaText);
    }

}
