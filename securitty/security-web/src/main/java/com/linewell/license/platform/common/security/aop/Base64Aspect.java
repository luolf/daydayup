package  com.linewell.license.platform.common.security.aop;

import com.linewell.license.platform.common.security.annotation.ParameterBase64;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;


/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-13
 * Time 9:08
 */
@Component
@Aspect
public class Base64Aspect {
	
	@Pointcut(value = "@annotation(com.linewell.license.platform.common.security.annotation.ParameterBase64)")
	public void access() {

	}

	// 环绕通知,环绕增强，相当于MethodInterceptor
	@Around("access()")
	public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

		Method method = methodSignature.getMethod();
		String[] parameterNames = methodSignature.getParameterNames();
		Object[] parameterNamesValues = joinPoint.getArgs();
		ParameterBase64 base64Annotation = AnnotationUtils.getAnnotation(method, ParameterBase64.class);
		String[] annotationValue = base64Annotation.value();
		List<String> annotationValueList = Arrays.asList(annotationValue);
		int index = 0;
		Object parameter;
		for (String parameterName : parameterNames) {
			if (annotationValueList.contains(parameterName)) {
				parameter = parameterNamesValues[index];
				if (parameter != null && parameter instanceof String) {
					parameterNamesValues[index] = new String(Base64Utils.decodeFromString((String) parameter));
				}

			}
			index++;
		}

		return joinPoint.proceed(parameterNamesValues);

	}

}
