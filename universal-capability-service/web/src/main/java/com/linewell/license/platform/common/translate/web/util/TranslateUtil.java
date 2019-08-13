package com.linewell.license.platform.common.translate.web.util;

import com.linewell.license.platform.common.translate.facade.dto.CommTrsParameterDto;
import com.linewell.license.platform.common.translate.facade.dto.ParamObject;
import com.linewell.license.platform.common.translate.facade.dto.TranslateObject;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-08
 * Time 16:23
 */
public class TranslateUtil {
    /**
     * Description 获取参数码列表
     * @return 返回值说明
     * @param translateObject 参数说明
     * @author luolifeng
     * Date  2019/8/8
     */
    public static List<String> getNeedTranslatedParamCodes(TranslateObject translateObject){
        List<String>  paramCodes=new ArrayList<>();
        if(translateObject==null || translateObject.getParams() ==null || translateObject.getParams().isEmpty()){
            return paramCodes;
        }
        List<ParamObject> paramObjects=translateObject.getParams();

        for(ParamObject paramObject:paramObjects){
            if(paramObject.isTranslated()){
                paramCodes.add(paramObject.getParamCode());
            }
        }
        return paramCodes;
    }

    /**
     * Description
     * @return 返回值说明
     * @param commTrsParameters 参数说明
     * @author luolifeng
     * Date  2019/8/8
     */
    public static Map<String, CommTrsParameterDto>  convertList2Map(List<CommTrsParameterDto>  commTrsParameters){
        Map<String,CommTrsParameterDto> rst=new HashMap<>(16);
        for(CommTrsParameterDto commTrsParameter:commTrsParameters){
            rst.put(commTrsParameter.getCode(), commTrsParameter);
        }
        return  rst;
    }

    /**
     *
     * Description  根据翻译好的map对象，將paramObjectList中的参数转换为String数组，方便消息格式化;若commTrsParameterMap为空，则使用默认值填充参数值
     * @return 参数数组
     * @param paramObjectList 参数列表
     * @param commTrsParameterMap 翻译好的参数map
     * @author luolifeng
     * Date  2019/8/8
     */
    public static String[] createParamObjects(List<ParamObject> paramObjectList,Map<String,CommTrsParameterDto> commTrsParameterMap){
        boolean isUseMap= commTrsParameterMap != null;

        /**无参数*/
        if(paramObjectList == null || paramObjectList.isEmpty()){
            return null;
        }

        String[] params=new String[paramObjectList.size()];
        for(int i=0;i<params.length;i++){
            ParamObject paramObject=paramObjectList.get(i);
            params[i]=paramObject.isTranslated()&& isUseMap ?commTrsParameterMap.get(paramObject.getParamCode()).getValue():paramObject.getParamDef();
        }
        return params;
    }

}
