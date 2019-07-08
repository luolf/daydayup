package com.example.demoservicec;

import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.common.utils.ReflectUtils;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.rpc.*;
import org.apache.dubbo.rpc.service.GenericService;

import java.lang.reflect.Method;

/**
 * Description 为抛出自定义异常
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-05-08
 * Time 11:01
 */

@Activate(
        group = {"provider"}
)
public class DubboExceptionFilter implements Filter {
    private final Logger logger;

    public DubboExceptionFilter() {
        this(LoggerFactory.getLogger(DubboExceptionFilter.class));
    }

    public DubboExceptionFilter(Logger logger) {
        this.logger = logger;
    }

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        try {
            return invoker.invoke(invocation);
        } catch (RuntimeException var4) {
            this.logger.error("Got unchecked and undeclared exception which called by " + RpcContext.getContext().getRemoteHost() + ". service: " + invoker.getInterface().getName() + ", method: " + invocation.getMethodName() + ", exception: " + var4.getClass().getName() + ": " + var4.getMessage(), var4);
            throw var4;
        }
    }

    public Result onResponse(Result result, Invoker<?> invoker, Invocation invocation) {
        if (result.hasException() && GenericService.class != invoker.getInterface()) {
            try {
                Throwable exception = result.getException();
                if (!(exception instanceof RuntimeException) && exception instanceof Exception) {
                    return result;
                } else {
                    try {
                        Method method = invoker.getInterface().getMethod(invocation.getMethodName(), invocation.getParameterTypes());
                        Class<?>[] exceptionClassses = method.getExceptionTypes();
                        Class[] var7 = exceptionClassses;
                        int var8 = exceptionClassses.length;

                        for(int var9 = 0; var9 < var8; ++var9) {
                            Class<?> exceptionClass = var7[var9];
                            if (exception.getClass().equals(exceptionClass)) {
                                return result;
                            }
                        }
                    } catch (NoSuchMethodException var11) {
                        return result;
                    }

                    this.logger.error("Got unchecked and undeclared exception which called by " + RpcContext.getContext().getRemoteHost() + ". service: " + invoker.getInterface().getName() + ", method: " + invocation.getMethodName() + ", exception: " + exception.getClass().getName() + ": " + exception.getMessage(), exception);
                    String serviceFile = ReflectUtils.getCodeBase(invoker.getInterface());
                    String exceptionFile = ReflectUtils.getCodeBase(exception.getClass());
                    if (serviceFile != null && exceptionFile != null && !serviceFile.equals(exceptionFile)) {
                        String className = exception.getClass().getName();
                        if (!className.startsWith("java.") && !className.startsWith("javax.") && !className.startsWith("com.linewell.license")) {
                            return (Result)(exception instanceof RpcException ? result : new RpcResult(new RuntimeException(StringUtils.toString(exception))));
                        } else {
                            return result;
                        }
                    } else {
                        return result;
                    }
                }
            } catch (Throwable var12) {
                this.logger.warn("Fail to ExceptionFilter when called by " + RpcContext.getContext().getRemoteHost() + ". service: " + invoker.getInterface().getName() + ", method: " + invocation.getMethodName() + ", exception: " + var12.getClass().getName() + ": " + var12.getMessage(), var12);
                return result;
            }
        } else {
            return result;
        }
    }
}

