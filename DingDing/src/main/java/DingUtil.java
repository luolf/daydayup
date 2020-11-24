/**
 * Created with IntelliJ IDEA.
 * Description: 我就是我, 是不一样的烟火
 * https://ding-doc.dingtalk.com/doc#/serverapi2/qf2nxq
 * https://blog.csdn.net/weixin_44082075/article/details/103163547
 * User: luolifeng
 * Date: 2020-11-18 11:25
 */
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.codec.binary.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

public class DingUtil {
    public static void main(String[] args) {

        try {
//            DingUtil.sendMsg(null,null,true);
            DingUtil.sendMsg(null,null,false);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }
    public static void sendMsg(String url,String name,boolean isAtAll) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {

        //群机器人复制到的秘钥secret
        String secret = "SEC8eb7ed34fd9cbae55488ef473810e19a65f4911206bda5d8e6fd0be741933fc4";
        //获取系统时间戳
        Long timestamp = System.currentTimeMillis();
        //拼接
        String stringToSign = timestamp + "\n" + secret;
        //使用HmacSHA256算法计算签名
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
        //进行Base64 encode 得到最后的sign，可以拼接进url里
        String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
        //钉钉机器人地址（配置机器人的webhook）
        String dingUrl = "https://oapi.dingtalk.com/robot/send?access_token=e3e43dbdfeea1dc9e8ac87d6160ef69eeb3206100ab20891c3949de1e14d9771&timestamp=" + timestamp + "&sign=" + sign;

        try {

            //是否通知所有人
//            boolean isAtAll = true;
            //通知具体人的手机号码列表
            List<String> mobileList = Lists.newArrayList();
//            mobileList.add("17720719802");
            mobileList.add("13635288370");
            String userUrl = url;
            //钉钉机器人消息内容
            String content = "你们已被微信限制,群发";
            //组装请求内容
            if(!isAtAll){
                content = "我就是我, 是不一样的烟火";
            }
            String reqStr = buildReqStr(content, isAtAll, mobileList);

            //推送消息（http请求）
            String result = HttpUtil.post(dingUrl, reqStr);
            // String result = HttpClientUtil.sendPostDataByJson(sign, reqStr,"utf8");
            System.out.println("result == " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 组装请求报文
     * @param content
     * @return
     */
    private static String buildReqStr(String content, boolean isAtAll, List<String> mobileList) {
        //消息内容
        Map<String, String> contentMap = Maps.newHashMap();
        if(!isAtAll){
            for(String mobile:mobileList){
                content=content+"@"+mobile;
            }
        }
        contentMap.put("content", content);
        //通知人
        Map<String, Object> atMap = Maps.newHashMap();
        //1.是否通知所有人
        atMap.put("isAtAll", isAtAll);
        //2.通知具体人的手机号码列表
        atMap.put("atMobiles", mobileList);

        Map<String, Object> reqMap = Maps.newHashMap();
        reqMap.put("msgtype", "text");
        reqMap.put("text", contentMap);
        reqMap.put("at", atMap);

        return JSON.toJSONString(reqMap);
    }
}
