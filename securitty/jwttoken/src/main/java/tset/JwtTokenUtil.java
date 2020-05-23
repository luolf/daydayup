package tset;

import com.alibaba.fastjson.JSON;
import com.linewell.license.platform.common.model.session.SessionInfo;
import com.linewell.license.platform.common.model.session.TokenDetails;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

/**
 * Description: 类描述
 *
 * @author luolifeng
 * version:1.0.0
 * Date: 2019-03-25
 * Time: 10:32
 */

public class JwtTokenUtil {

    /**
     * accessToken 过期时间 单位秒
     */
    @Value("#{${license.security.jwt.token.tokenExpired:60}*60}")
    private static long TOKEN_EXPIRED_TIME = 11L;
    /**
     * reflush accessToken 过期时间 单位秒
     */
    @Value("#{${license.security.jwt.token.reflushTokenExpired:120}*60}")
    private static long REFLUSH_TOKEN_EXPIRED_TIME = 3600L;
    /**
     * 选择了记住我之后的过期时间 单位秒
     */
    @Value("#{${license.security.jwt.tokenExpiredRemember:7}*60*60*24}")
    private static long EXPIRATION_REMEMBER = 7 * 24 * 3600L;

    /**
     * jwt 加密解密密钥
     */
    private static String JWT_SECRET = "bGluZXdlbGwtbGljZW5zZS1yb28=";

    private static final String JWT_ID = "tokenId";




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
        return sessionInfo;

    }

    /**
     * Description
     *
     * @param token 合法token
     * @return TokenDetails 非法token返回null, 否则转换token中的playload为SessionInfo对象返回
     * @author luolifeng
     * Date 2019/3/26
     */
    public static TokenDetails parseTokenDetails (String token) {
        SecretKey key = generalKey(JWT_SECRET);
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        TokenDetails tokenDetails = JSON.parseObject(JSON.toJSONString(claims), TokenDetails.class);
        tokenDetails.setIat(tokenDetails.getIat() / 1000);
        return tokenDetails;

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

    public static void main(String[] args) {


        String token="eyJhbGciOiJIUzUxMiJ9.eyJiZWxvbmdBcmVhSWQiOjEsImFjY291bnRJZCI6NDcsInN1YiI6ImxsZiIsInJvbGVJZExpc3QiOls0N10sImJlbG9uZ09yZ0lkIjotOTksImxhbmd1YWdlIjoiemhfQ04iLCJleHAiOjE3ODQwMzA0NDUsImlhdCI6MTU2ODAzMDQ0NSwiYWNjb3VudCI6ImxsZiIsImp0aSI6ImUzZDRiNWQ0Yzk2YTRjNmViMDI2YTk2YzVkNWJkYTUzIn0.bU93BKQRmdA-QM4xjQc5YRsNetyfxbVZXeY05jHQ_Xitvl0x5pkDQNVJSqFiyixdgTxm4jiC_Mrtia8rYsmdMg";
        TokenDetails tokenDetails=JwtTokenUtil.parseTokenDetails(token);
        System.out.println(JSON.toJSONString(tokenDetails));

    }

}
