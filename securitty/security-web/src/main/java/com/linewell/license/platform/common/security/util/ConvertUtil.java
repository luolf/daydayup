package com.linewell.license.platform.common.security.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.beans.BeanMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;

/**
 * Description bean之间的转换工具
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-04-23
 * Time 12:16
 */
public class ConvertUtil {
    private static Map<String, BeanCopier> beanCopierMap = new HashMap<>(32);
    private static String generateKey(Class<?>class1,Class<?>class2){
        return class1.toString() + class2.toString();
    }
    private ConvertUtil(){}

    public static <T, V> V copyProperties(T source,Class<V> targetclazz ) throws IllegalAccessException, InstantiationException {
        V target= targetclazz.newInstance();
        String beanKey = generateKey(source.getClass(),target.getClass());
        BeanCopier copier;
        if (!beanCopierMap.containsKey(beanKey)) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            beanCopierMap.put(beanKey, copier);
        }else {
            copier = beanCopierMap.get(beanKey);
        }
        copier.copy(source, target, null);
        return target;
    }
    /**
     * 将List<T>转为List<V>
     * @param srcList List<V>
     * @param destclazz Class<T>
     * @return  list List<T>
     */
    public static <T,V> List<T> listTolist(List<V> srcList, Class<T> destclazz) throws IllegalAccessException, InstantiationException {
        List<T> list = Lists.newArrayList();
        if (srcList != null &&  !srcList.isEmpty()) {
            T destBean;
            for (V srcBean : srcList) {
                destBean=copyProperties(srcBean,destclazz);
                list.add(destBean);
            }
        }
        return list;
    }
    /**
     * Page<T>PageV>
     * @param src Page<V>
     * @param destclazz Class<T>
     * @return  page<T></T> Page<T>
     */
//    public static <T,V> Page<T> esPageToPage(Page<V> src, Class<T> destclazz) throws IllegalAccessException, InstantiationException {
//        List<T> list = listTolist(src.getContent(),destclazz);
//        return new PageImpl<>(list,src.getPageable(),src.getTotalElements());
//    }

    /**
     * 将对象装换为map
     * @param bean T
     * @return map
     */
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = Maps.newHashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key + "", beanMap.get(key));
            }
        }
        return map;
    }

    /**
     * 将map装换为javabean对象
     * @param map Map<String, Object>
     * @param bean T
     * @return bean
     */
    public static <T> T mapToBean(Map<String, Object> map,T bean) {
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }

    /**
     * 将List<T>转换为List<Map<String, Object>>
     * @param objList List<T>
     * @return list
     */
    public static <T> List<Map<String, Object>> objectsToMaps(List<T> objList) {
        List<Map<String, Object>> list = Lists.newArrayList();
        if (objList != null && !objList.isEmpty()) {
            Map<String, Object> map;
            T bean;
            for (T t : objList) {
                bean = t;
                map = beanToMap(bean);
                list.add(map);
            }
        }
        return list;
    }

    /**
     * 将List<Map<String,Object>>转换为List<T>
     * @param maps List<Map<String, Object>>
     * @param clazz Class<T>
     * @return list
     * @throws InstantiationException InstantiationException
     * @throws IllegalAccessException IllegalAccessException
     */
    public static <T> List<T> mapsToObjects(List<Map<String, Object>> maps, Class<T> clazz) throws InstantiationException, IllegalAccessException {
        List<T> list = Lists.newArrayList();
        if (maps != null &&  !maps.isEmpty()) {
            Map<String, Object> map;
            T bean;
            for (Map<String, Object> stringObjectMap : maps) {
                map = stringObjectMap;
                bean = clazz.newInstance();
                mapToBean(map, bean);
                list.add(bean);
            }
        }
        return list;
    }
}

