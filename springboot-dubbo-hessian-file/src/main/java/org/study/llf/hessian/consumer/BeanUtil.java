package org.study.llf.hessian.consumer;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-10-18
 * Time 11:18
 */
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class BeanUtil {

    public static <T> Map<String,Object> beanInclude(T t, String... includes){
        return processBean(t,false, includes);
    }
    public static <T> Map<String,Object> beanFilter(T t, String... filters){
        return processBean(t,true, filters);
    }

    public static <T> List<Map<String,Object>> listBeanInclude(List<T> list, String... includes) {
        return processListBean(list, false, includes);
    }

    public static <T> List<Map<String,Object>> listBeanFilter(List<T> list, String... filters) {
        return processListBean(list, true, filters);
    }

    private static <T> Map<String,Object> processBean(T t,boolean isFilter, String... atts) {
        if (t == null )return null;
        Map<String,Object> map=new HashMap<>();
        BeanWrapper model = new BeanWrapperImpl(t);
        PropertyDescriptor[] props = model.getPropertyDescriptors();
        for (int j = 0; j < props.length; j++) {
            PropertyDescriptor prop = props[j];
            String attributeName = prop.getName();
            boolean isPut=false;
            if (atts == null || atts.length == 0){
                isPut=true;
            }else {
                boolean has=false;
                for (String att : atts) {
                    if(attributeName.equals(att)) {
                        has=true;
                        break;
                    }
                }
                if(isFilter) {
                    if(!has) {
                        isPut=true;
                    }
                }else {
                    if(has) {
                        isPut=true;
                    }
                }
            }
            if(isPut) map.put(attributeName, model.getPropertyValue(attributeName));
        }
        return map;
    }
    private static <T> List<Map<String,Object>> processListBean(List<T> list, boolean isFilter, String... atts) {
        if (list == null || list.size() == 0)return null;
        List<Map<String,Object>> listMap=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            T t = list.get(i);
            listMap.add(processBean(t, isFilter, atts));
        }
        return listMap;
    }
}