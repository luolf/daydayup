package com.linewell.license.platform.common.security.advice;

import com.alibaba.fastjson.JSON;
import com.linewell.license.platform.common.model.annotation.PassAdviceAnnotation;
import com.linewell.license.platform.common.model.result.ResultBaseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Description 统一处理controller的返回封装
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-03-27
 * Time 10:40
 */
@ControllerAdvice(basePackages={"com.linewell.license.platform.common.security"})
public class WebResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    private final Logger log = LoggerFactory.getLogger(WebResponseBodyAdvice.class);
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return  methodParameter.getMethodAnnotation(PassAdviceAnnotation.class) !=null;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        String uri = serverHttpRequest.getURI().toString();
        HttpServletRequest servletRequest = ((ServletServerHttpRequest)serverHttpRequest).getServletRequest();
        String requestUriWithoutContextPath =
                servletRequest.getRequestURI().substring(servletRequest.getContextPath().length());

        log.info("请求:{} | 返回={}", requestUriWithoutContextPath, JSON.toJSONString(o));

        if(jumpAdvice(uri)){
            return o;
        }

        if (o instanceof ResultBaseModel) {
            return o;
        }
        if (o instanceof Byte) {
            return o;
        }
        if (o instanceof String) {
            return o;
        }
        return new ResultBaseModel<>("200","success",o);
    }


    private boolean jumpAdvice(String uri){
        for (String string : JUMP_LIST) {
            if (uri.contains(string)) {
                return true;
            }
        }
        return false;
    }

    private static final List<String> JUMP_LIST = new ArrayList<>();
    static {
        JUMP_LIST.add("/swagger-resources");
        JUMP_LIST.add("/v2/api-docs");

    }
}
