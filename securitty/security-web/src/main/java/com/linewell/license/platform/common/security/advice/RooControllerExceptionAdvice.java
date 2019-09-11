package com.linewell.license.platform.common.security.advice;

import com.alibaba.fastjson.JSON;
import com.linewell.license.platform.common.model.exception.RooBaseException;
import com.linewell.license.platform.common.model.result.ResultBaseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Description 通用的统一异常处理
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-04-10
 * Time 17:31
 */
@ControllerAdvice(basePackages={" com.linewell.license.platform.common.security"})
public class RooControllerExceptionAdvice {

    private ThreadLocal<Object> modelHolder = new ThreadLocal<>();
    private final Logger log = LoggerFactory.getLogger(RooControllerExceptionAdvice.class);


    private String getRequestBody(){
        return JSON.toJSONString(modelHolder.get());
    }


    @ResponseBody
    @ExceptionHandler(RooBaseException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResultBaseModel<Object> handlerRooBaseException(RooBaseException e,
                                                           HttpServletRequest request) {
        log.error("RooBaseException异常!requestUri={}| requestBody={}| errMsg={}", request.getRequestURI(),getRequestBody(), e.getErrMsg());
        return new ResultBaseModel<>(e.getErrCode(), e.getErrMsg(), e.getErrMsg());
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        // ModelHolder 初始化0
        modelHolder.set(webDataBinder.getTarget());
    }
}
