package com.linewell.license.platform.common.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 类描述
 *
 * @author luolifeng
 * version:1.0.0
 * Date: 2019-03-25
 * Time: 10:32
 */
@Component
public class JwtTokenUtil {
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    /**
     *   token 过期时间是3600秒，既是1个小时
     */
    @Value("${license.security.token.Expired}")
    public static  long TOKEN_EXPIRED_TIME = 3600000L;

    /**
     * 选择了记住我之后的过期时间为7天
     */
    @Value("${license.security.token.ExpiredRemember}")
    private static  long EXPIRATION_REMEMBER = 60L;

    public static long getTokenExpiredTime() {
        return TOKEN_EXPIRED_TIME;
    }

    public  void setTokenExpiredTime(long tokenExpiredTime) {
        JwtTokenUtil.TOKEN_EXPIRED_TIME = tokenExpiredTime;
    }

    public static long getExpirationRemember() {
        return EXPIRATION_REMEMBER;
    }

    public  void setExpirationRemember(long expirationRemember) {
        JwtTokenUtil.EXPIRATION_REMEMBER = expirationRemember;
    }

    /**
     * jwt 加密解密密钥
     */
    private static final String JWT_SECRET = "bGluZXdlbGwtbGljZW5zZS1yb28=";

    private static final String JWT_ID = "tokenId";

    private static final Integer STRENGTH = 10;
    /**
     * 登录密码加密器
     */
    private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(STRENGTH);


    /**
     * Description
     * @return 加密后的密钥
     * @param  passwd 需要加密的字符串
     * @author luolifeng
     * Date 2019/3/26
     */
    public static String encodePasswd(String passwd){
       return passwordEncoder.encode(passwd);
    }

    /**
     * Description
     * @return true密码匹配
     * @param passwd 加密前原文
     * @param secretPasswd 加密后密钥
     * @author luolifeng
     * Date 2019/3/26
     */
    public static boolean matchPasswd(String passwd,String secretPasswd) {
        return passwordEncoder.matches(passwd,secretPasswd);
    }

    /**
     * Description 由字符串生成加密key
     * @return 密钥SecretKey
     * @param base64key 通过一个base64的字符串来生产 SecretKey
     * @author luolifeng
     * Date 2019/3/26
     */
    private static SecretKey generalKey(String base64key) {
        byte[] encodedKey=Base64.getDecoder().decode(base64key);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }

    public static String generalToken(Map<String, Object> myClaims, boolean isRememberMe) {
        long expireTime = isRememberMe ? EXPIRATION_REMEMBER : TOKEN_EXPIRED_TIME;
        return generalToken(myClaims,expireTime);
    }

    /**
     * Description
     * @return token
     * @param myClaims 私有键值对
     * @param expireTime  过期步长，单位秒
     * @author luolifeng
     * Date 2019/3/26
     */
    private static String generalToken(Map<String, Object> myClaims, long expireTime) {
        long millis=System.currentTimeMillis();
        Date iat = new Date(millis);
        Date expire = new Date(millis+expireTime*1000);
        SecretKey secretKey = generalKey(JWT_SECRET);

        JwtBuilder builder = Jwts.builder()
                .setClaims(myClaims).setSubject(myClaims.get("username").toString()).setExpiration(expire)
                .setId(JWT_ID)
                .setIssuedAt(iat)
                .signWith(SignatureAlgorithm.HS512, secretKey);

        return builder.compact();
    }

    /**
     * Description
     * @return token
     * @param myClaims 私有键值对
     * @author luolifeng
     * Date 2019/3/26
     */
    public static String generalToken(Map<String, Object> myClaims) {
        return  generalToken(myClaims,TOKEN_EXPIRED_TIME);
    }


    /**
     * Description 校验token
     * @return true表示校验通过，否则不通过
     * @param token 被校验的token
     * @author luolifeng
     * Date 2019/3/26
     */
    public static boolean verifyToken(String token) {

        Claims claims=getClaims(token);
        return claims != null;


    }

    /**
     * Description
     * @return 用户名
     * @param token
     * @author luolifeng
     * Date 2019/3/26
     */
    public static String getUsername(String token){
        Claims body =getClaims(token);
        if(body==null){
            return null;
        }
        return body.getSubject();
    }

    // 是否已过期
    public static boolean isExpiration(String token){
        Claims claims;
        try {
            return getClaims(token).getExpiration().before(new Date());
        } catch (Exception e) {
            return true;
        }

    }

    /**
     * Description
     * @return 非法token返回null,否则返回token中的playload内容
     * @param token 合法token
     * @author luolifeng
     * Date 2019/3/26
     */
    public static Claims getClaims(String token) {
        SecretKey key = generalKey(JWT_SECRET);
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * Description
     * @return 传入的token异常则返回null,否则返回token中的用户账号
     * @param token 合法token
     * @author luolifeng
     * Date 2019/3/26
     */
    public static String getAccount(String token) {
        Claims body =getClaims(token);
        if(body==null){
            return null;
        }
        return (String)(body.get("account"));

    }

    /**
     * Description
     * @return 传入的token异常则返回null,否则返回token中的用户账号
     * @param token 合法token
     * @author luolifeng
     * Date 2019/3/26
     */
//    public static MySessionInfo getMySessionInfo(String token) {
//        MySessionInfo mySessionInfo=new MySessionInfo();
//        Claims body =getClaims(token);
//        if(body==null){
//            return mySessionInfo;
//        }
//        mySessionInfo.setAccount((String)body.get("account"));
//        mySessionInfo.setIat(body.getIssuedAt().getTime() / 1000);
//        mySessionInfo.setUserId((String)body.get("userId"));
//        mySessionInfo.setUserName((String)body.get("userName"));
//        return mySessionInfo;
//
//    }
    public static void main(String[] args) throws InterruptedException {
        Map<String, Object> myClaims = new HashMap<>(16);
        myClaims.put("account","license");
        myClaims.put("userId","userId1001");
        myClaims.put("userName","llf");
        myClaims.put("account","license");

        String token=generalToken(myClaims,false);
//        String token="eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyTmFtZSI6ImxsZiIsImV4cCI6MTU2NTY4OTQzMSwidXNlcklkIjoidXNlcklkMTAwMSIsImlhdCI6MTU2NTY4OTM4MSwiYWNjb3VudCI6ImxpY2Vuc2UiLCJqdGkiOiJ0b2tlbklkIn0.MtMFFQY36XcSxXoFf6uOZeEARQPeAXlXK-KnOZuMJKFHypxYiKOfbxVW8y_zQ6WdwgRzlsH90q4zmfq49cgsdQ";
        System.out.println("token："+token+"|");
        System.out.println("account："+getAccount(token));
        System.out.println("Claims："+getClaims(token));
        System.out.println("是否过期："+isExpiration(token));
        System.out.println("当期日期："+new Date());
        System.out.println("Expiration："+ getClaims(token).getExpiration());
        Thread.sleep(6000);

        System.out.println("Claims："+getClaims(token));
        System.out.println("是否过期："+isExpiration(token));

        String passwd="123456";
        String encodePasswd=JwtTokenUtil.encodePasswd(passwd);
        System.out.println("encodePasswd："+encodePasswd );
        System.out.println("encodePasswd2："+JwtTokenUtil.encodePasswd(passwd) );
        boolean match=JwtTokenUtil.matchPasswd(passwd,encodePasswd);
        System.out.println("match："+match );
        System.out.println("match2："+JwtTokenUtil.matchPasswd("12345 ",JwtTokenUtil.encodePasswd(passwd) ) );
    }
}
