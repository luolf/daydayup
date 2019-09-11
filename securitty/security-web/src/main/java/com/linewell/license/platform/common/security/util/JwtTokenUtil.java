package com.linewell.license.platform.common.security.util;

import com.alibaba.fastjson.JSON;
import com.linewell.license.platform.common.model.session.SessionInfo;
import com.linewell.license.platform.common.security.authen.JwtUserDetails;
import com.linewell.license.platform.common.security.authen.UserPrincipal;
import com.linewell.license.platform.common.security.config.SecurityConfigBean;
import com.linewell.license.platform.common.security.dto.MidToken;
import io.jsonwebtoken.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

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

    /**
     * token 过期时间 单位秒
     */

    private static long TOKEN_EXPIRED_TIME = 11L;
    /**
     * reflush token 过期时间 单位秒
     */

    private static long REFLUSH_TOKEN_EXPIRED_TIME = 3600L;
    /**
     * 选择了记住我之后的过期时间 单位秒
     */

    private static long EXPIRATION_REMEMBER = 7 * 24 * 3600L;

    /**
     * jwt 加密解密密钥
     */
    private static String JWT_SECRET = "bGluZXdlbGwtbGljZW5zZS1yb28=";

    private static final String JWT_ID = "tokenId";


    public static void setConfigInfo(SecurityConfigBean securityConfigBean) {
        JWT_SECRET = securityConfigBean.getJwtSecret();
        TOKEN_EXPIRED_TIME = securityConfigBean.getTokenExpiredTime();
        EXPIRATION_REMEMBER = securityConfigBean.getTokenExpiredTimeRemember();
        REFLUSH_TOKEN_EXPIRED_TIME = securityConfigBean.getReflushTokenExpiredTime();

    }


    /**
     * Description 由字符串生成加密key
     *
     * @param base64key 通过一个base64的字符串来生产 SecretKey
     * @return 密钥SecretKey
     * @author luolifeng
     * Date 2019/3/26
     */
    private static SecretKey generalKey(String base64key) {

        byte[] encodedKey = Base64.getDecoder().decode(base64key);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }

    public static MidToken generalMidToken(SessionInfo sessionInfo) {
        MidToken midToken = new MidToken();
        String id=UUIDUtil.getUUID();
        midToken.setToken(generalToken(sessionInfo,id));
        midToken.setReflushtoken(generalReflushToken(sessionInfo,id));
        return midToken;
    }

    private static String generalToken(SessionInfo sessionInfo,String id) {
        return generalToken(sessionInfo, false,id);
    }
    private static String generalToken(SessionInfo sessionInfo) {
        return generalToken(sessionInfo, false,UUIDUtil.getUUID());
    }
    private static String generalReflushToken(SessionInfo sessionInfo) {
        return generalToken(sessionInfo, REFLUSH_TOKEN_EXPIRED_TIME,UUIDUtil.getUUID());
    }


    private static String generalReflushToken(SessionInfo sessionInfo,String id) {
        return generalToken(sessionInfo, REFLUSH_TOKEN_EXPIRED_TIME,id);
    }

    private static String generalToken(SessionInfo sessionInfo, boolean isRememberMe,String id) {
        long expireTime = isRememberMe ? EXPIRATION_REMEMBER : TOKEN_EXPIRED_TIME;
        return generalToken(sessionInfo, expireTime,id);
    }

    private static String generalToken(SessionInfo sessionInfo, long expireTime,String id) {

        long millis = System.currentTimeMillis();
        Date iat = new Date(millis);
        Date expire = new Date(millis + expireTime * 1000);
        SecretKey secretKey = generalKey(JWT_SECRET);

        JwtBuilder builder = Jwts.builder().setClaims(ConvertUtil.beanToMap(sessionInfo))
                .setSubject(sessionInfo.getUserName()).setExpiration(expire)
//                .setId(JWT_ID)
                .setId(id)
                .setIssuedAt(iat)
                .signWith(SignatureAlgorithm.HS512, secretKey);

        return builder.compact();

    }

    private static String generalToken(Map<String, Object> myClaims, boolean isRememberMe,String id) {
        long expireTime = isRememberMe ? EXPIRATION_REMEMBER : TOKEN_EXPIRED_TIME;
        return generalToken(myClaims, expireTime, id);
    }

    /**
     * Description
     *
     * @param myClaims   私有键值对
     * @param expireTime 过期步长，单位秒
     * @return token
     * @author luolifeng
     * Date 2019/3/26
     */
    private static String generalToken(Map<String, Object> myClaims, long expireTime,String id) {
        long millis = System.currentTimeMillis();
        Date iat = new Date(millis);
        Date expire = new Date(millis + expireTime * 1000);
        SecretKey secretKey = generalKey(JWT_SECRET);

        JwtBuilder builder = Jwts.builder()
                .setClaims(myClaims).setSubject(myClaims.get("account").toString()).setExpiration(expire)
//                .setId(JWT_ID)
                .setId(id)
                .setIssuedAt(iat)
                .signWith(SignatureAlgorithm.HS512, secretKey);

        return builder.compact();
    }

    /**
     * Description
     *
     * @param myClaims 私有键值对
     * @return token
     * @author luolifeng
     * Date 2019/3/26
     */
    public static String generalToken(Map<String, Object> myClaims,String id) {
        return generalToken(myClaims, TOKEN_EXPIRED_TIME,id);
    }


    /**
     * Description 校验token
     *
     * @param token 被校验的token
     * @return true表示校验通过，否则不通过
     * @author luolifeng
     * Date 2019/3/26
     */
    public static boolean verifyToken(String token) {
        Claims claims = getClaims(token);
        return claims != null;
    }

    /**
     * Description
     *
     * @param token
     * @return 用户名
     * @author luolifeng
     * Date 2019/3/26
     */
    public static String getUsername(String token) {
        Claims body = getClaims(token);
        if (body == null) {
            return null;
        }
        return body.getSubject();
    }
    /**
     * Description
     *
     * @param token
     * @return tokenId
     * @author luolifeng
     * Date 2019/3/26
     */
    public static String getTokenId(String token) {
        Claims body = getClaims(token);
        if (body == null) {
            return null;
        }
        return body.getId();
    }
    /**
     * Description
     *
     * @param token
     * @return tokenId
     * @author luolifeng
     * Date 2019/3/26
     */
    public static Date getTokenExpiredTime(String token) {
        Claims body = getClaims(token);
        if (body == null) {
            return null;
        }
        return body.getExpiration();
    }
    // 是否已过期
    public static boolean isExpiration(String token) {
        try {
            return getClaims(token).getExpiration().before(new Date());

        } catch (SignatureException e) {

        } catch (ExpiredJwtException e) {
            return true;
        } catch (Exception e) {

        }
        return false;
    }



    /**
     * Description
     *
     * @param token 合法token
     * @return 非法token返回null, 否则转换token中的playload为SessionInfo对象返回
     * @author luolifeng
     * Date 2019/3/26
     */
    public static SessionInfo parseToken(String token) {
        SecretKey key = generalKey(JWT_SECRET);
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        SessionInfo sessionInfo = JSON.parseObject(JSON.toJSONString(claims), SessionInfo.class);
        sessionInfo.setIat(sessionInfo.getIat() / 1000);
        return sessionInfo;

    }

    /**
     * Description
     *
     * @param token 合法token
     * @return 非法token返回null, 否则返回token中的playload内容
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
     *
     * @param token 合法token
     * @return 传入的token异常则返回null, 否则返回token中的用户账号
     * @author luolifeng
     * Date 2019/3/26
     */
    public static String getAccount(String token) {
        Claims body = getClaims(token);
        if (body == null) {
            return null;
        }
        return (String) (body.get("account"));

    }

    public static SessionInfo generalSessionInfo(JwtUserDetails principal) {
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.setUserId(principal.getUserId());
        sessionInfo.setUserName(principal.getUsername());
        //要支持语言切换功能，则不应该把语言信息放到sessionInfo,后续调整
        sessionInfo.setLanguage("zh_CN");
        sessionInfo.setRoleIdList(principal.getRoleList());
        sessionInfo.setIat(System.currentTimeMillis());
        sessionInfo.setBelongAreaId(principal.getBelongAreaId());
        sessionInfo.setBelongOrgId(principal.getBelongOrgId());
        return sessionInfo;
    }

    public static void main(String[] args) throws InterruptedException {
        Map<String, Object> myClaims = new HashMap<>(16);
        myClaims.put("account", "license");
        myClaims.put("userId", "userId1001");
        myClaims.put("account", "llf");
        myClaims.put("account", "license");

        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.setUserId(1001L);
//        sessionInfo.setUserName("llf");
//        Set<Long> roleIdList=new HashSet<>();
//        roleIdList.add(1L);
//        roleIdList.add(2L);
//        sessionInfo.setRoleIdList(roleIdList);

        String token = generalToken(sessionInfo, false,"");
        SecretKey key = generalKey(JWT_SECRET);

        Jws<Claims> jwts = Jwts.parser().setSigningKey(key).parseClaimsJws(token);
        Claims claims = jwts.getBody();
        claims.getId();

//        String token="eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyTmFtZSI6ImxsZiIsImV4cCI6MTU2NTY4OTQzMSwidXNlcklkIjoidXNlcklkMTAwMSIsImlhdCI6MTU2NTY4OTM4MSwiYWNjb3VudCI6ImxpY2Vuc2UiLCJqdGkiOiJ0b2tlbklkIn0.MtMFFQY36XcSxXoFf6uOZeEARQPeAXlXK-KnOZuMJKFHypxYiKOfbxVW8y_zQ6WdwgRzlsH90q4zmfq49cgsdQ";
        System.out.println("token：" + token + "|");
        System.out.println("parseToken：" + parseToken(token));
        System.out.println("Claims：" + getClaims(token));
        System.out.println("是否过期：" + isExpiration(token));
        System.out.println("claims.getId()：" + getClaims(token).getId());
        System.out.println("当期日期：" + new Date());
        System.out.println("Expiration：" + getClaims(token).getExpiration());
        Thread.sleep(1000);

        System.out.println("Claims：" + getClaims(token));
        System.out.println("是否过期：" + isExpiration(token));
        System.out.println(parseToken(null));
        System.out.println("是否过期：" + isExpiration(null));
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
        String passwd = "123456";
        for (int i = 0; i < 5; i++) {
            System.out.println("encode passwd：" + bCryptPasswordEncoder.encode(passwd));
        }

        System.out.println(Boolean.valueOf("True"));


    }
}
