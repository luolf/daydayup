package com.linewell.license.platform.common.security.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.linewell.license.platform.common.model.constants.security.SecurityConstants;
import com.linewell.license.platform.common.model.session.SessionInfo;
import com.linewell.license.platform.common.security.config.SecurityConfigBean;
import com.linewell.license.platform.common.security.dto.MidToken;
import com.linewell.license.platform.common.security.service.UserCheckService;
import com.linewell.license.platform.common.security.util.JwtTokenUtil;
import com.linewell.license.platform.security.facade.service.AuthenCallBackFacade;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 验证码获取和验证
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-13
 * Time 9:08
 */
@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, value = "/auth")

public class AuthController {

    @Autowired
    private DefaultKaptcha captchaProducer;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Value("${license.security.captcha.timeout}")
    private Integer timeout;
    @Autowired
    SecurityConfigBean securityConfigBean;

    @Autowired
    AuthenCallBackFacade authenCallBackFacade;
    @Autowired
    UserCheckService userCheckService;

    /**
     * 获取验证码图片
     *
     * @param response
     * @throws Exception
     */
    @RequestMapping("/captcha/fetch")
    public void getImageKaptcha(HttpServletResponse response, HttpServletRequest request) throws IOException {
//        String uuid = UUIDUtil.getUUID();

        String captchaId=request.getHeader("Captcha-ID");
        if(StringUtil.isNullOrEmpty(captchaId)){
            captchaId=request.getSession().getId();
        }
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Captcha-ID",captchaId );
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        // 生成验证码
        String capText = captchaProducer.createText();
        capText = "000000";
        redisTemplate.opsForValue().set(SecurityConstants.REDIS_CODE_CAPTCHA + request.getSession().getId(), capText, timeout, TimeUnit.MINUTES);

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
     * 图片验证码校验
     *
     * @param captchaId   验证码id
     * @param captchaText 验证码
     * @return Boolean
     */
    @GetMapping("/captcha/validate")
    public Boolean captchaValidate(String captchaId, String captchaText) {

        String captcha = redisTemplate.opsForValue().get(SecurityConstants.REDIS_CODE_CAPTCHA + captchaId);
        if (StringUtils.isEmpty(captcha)) {
            throw new RuntimeException("验证码不正确");
        }
        return captcha.equalsIgnoreCase(captchaText);

    }

    /**
     * 短信验证码获取
     *
     * @param phoneNum 手机号
     * @return 短信验证码
     */
    @ResponseBody
    @GetMapping("/sms/fetch")
    public String getSmsCode(String phoneNum) {
        String text = captchaProducer.createText();
        text = "000000";
        redisTemplate.opsForValue().set(SecurityConstants.REDIS_CODE_MOBILE + phoneNum, text, timeout, TimeUnit.MINUTES);
        return text;
    }

    /**
     * 短信验证码获取
     *
     * @param username 账号
     * @return 短信验证码
     */
    @ResponseBody
    @GetMapping("/smsCode")
    public String getSmsCodeByUsername(String username) {
        if ("llf".equals(username)) {
            return getSmsCode("17720719802");
        }
        return getSmsCode("17720719801");

    }


    @ResponseBody
    @GetMapping("/test")
    public Object test(HttpServletRequest request) {
        System.out.println(request.getRemoteHost());
        System.out.println(request.getRequestedSessionId());
        System.out.println(request.getUserPrincipal());

        System.out.println("-----------------------------");
        System.out.println(request.getSession().getId());
        System.out.println(request.getSession());
        System.out.println(request.getSession().getCreationTime());
        System.out.println(request.getSession().getLastAccessedTime());
        return "sucess";

    }

    /**
     * 刷新token
     *
     * @param reflushToken 用来获取新token的token
     * @return 短信验证码
     */
    @ResponseBody
    @GetMapping("/token/reflush")
    public MidToken reflushToken(String reflushToken) {
        SessionInfo sessionInfo = userCheckService.checkUser(reflushToken);
        MidToken midToken = JwtTokenUtil.generalMidToken(sessionInfo);
        //记录到redis,在注销、作废、刷新的地方都有互动
        String reflushTokenId=JwtTokenUtil.getTokenId(midToken.getReflushtoken());
        redisTemplate.opsForValue().set(SecurityConstants.REDIS_TOKEN+sessionInfo.getAccountId(),reflushTokenId,securityConfigBean.getReflushTokenExpiredTime(), TimeUnit.MINUTES);
        return midToken;

    }
}
