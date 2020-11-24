import com.alibaba.fastjson.JSON;
import com.baidu.aip.face.AipFace;
import lombok.Data;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: luolifeng
 * Date: 2020-11-24 10:09
 */
public class FaceUtil {

    public class BaiduKey{
        public  String APP_ID ;
        public  String API_KEY ;
        public  String SECRET_KEY ;

        public BaiduKey(String APP_ID, String API_KEY, String SECRET_KEY) {
            this.APP_ID = APP_ID;
            this.API_KEY = API_KEY;
            this.SECRET_KEY = SECRET_KEY;
        }

        public String getAPP_ID() {
            return APP_ID;
        }

        public void setAPP_ID(String APP_ID) {
            this.APP_ID = APP_ID;
        }

        public String getAPI_KEY() {
            return API_KEY;
        }

        public void setAPI_KEY(String API_KEY) {
            this.API_KEY = API_KEY;
        }

        public String getSECRET_KEY() {
            return SECRET_KEY;
        }

        public void setSECRET_KEY(String SECRET_KEY) {
            this.SECRET_KEY = SECRET_KEY;
        }
    }
    //设置APPID/AK/SK
    public static final String APP_ID = "23017498";
    public static final String API_KEY = "xIX8Y8sIpqP0iBw4dHy39kaV";
    public static final String SECRET_KEY = "jpF039oPL8HQ45t4tTgGAZnCOzWlr9yd";
    public static List<BaiduKey> baiduKeys;
    public static List<AipFace> aipFaces=new ArrayList<>();

    static {
//        baiduKeys.add(new BaiduKey("23017504","gZqL3OGfsGfwmc6IjXG8w1D9","eAftQSiSccHhfVmBCq0nqAzF9kVXTRM3"));
//         baiduKeys.add(new BaiduKey("23017498","xIX8Y8sIpqP0iBw4dHy39kaV","jpF039oPL8HQ45t4tTgGAZnCOzWlr9yd"));

         aipFaces.add(new AipFace("23017504","gZqL3OGfsGfwmc6IjXG8w1D9","eAftQSiSccHhfVmBCq0nqAzF9kVXTRM3"));
         aipFaces.add(new AipFace("23017498","xIX8Y8sIpqP0iBw4dHy39kaV","jpF039oPL8HQ45t4tTgGAZnCOzWlr9yd"));
    }

    public static void main(String[] args) {
        // 初始化一个AipFace

//        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
//        client.setConnectionTimeoutInMillis(6000);
//        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理
// 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("face_field", "age");
        options.put("max_face_num", "2");
        options.put("face_type", "LIVE");
        options.put("liveness_control", "LOW");
        // 调用接口
        String image = "取决于image_type参数，传入BASE64字符串或URL字符串或FACE_TOKEN字符串";
        image = "https://p16-sign-sg.tiktokcdn.com/tos-alisg-avt-0068/smge2ef31fc20b99b725e615fe893bd92ef~c5_300x300.webp?x-expires=1606222800&x-signature=%2FXPs5jdtfAekcOVOE0JsGWyqFHY%3D";
        image ="https://p16-sign-va.tiktokcdn.com/musically-maliva-obj/1653832654771206~c5_300x300.webp?x-expires=1606258800&x-signature=oPmeh8zNUQLOAiAb5ImPgfxoego%3D";
        String imageType = "URL";
        for(AipFace client : aipFaces) {
            // 人脸检测
            JSONObject res = client.detect(image, imageType, options);
            System.out.println(res.toString(2));
            System.out.println(res.toString());
            Result rst= JSON.parseObject(res.toString(),Result.class);
            if(rst.getError_code()!=222204){
                break;
            }
        }

    }
    @Data
    public static class Result{
        public String result;
        public String log_id;
        public String error_msg;
        public String cached;
        public int error_code;
        public String timestamp;
    }
}
