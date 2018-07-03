package com.imooc.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.validator.internal.util.privilegedactions.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class HttpAspect {
	
	private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

	@Pointcut("execution(public * com.imooc.controller.GirlController.*(..))")
	public void log() {
		
	}
	
	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		
		logger.info("url={}", request.getRequestURL());
		
		logger.info("method={}", request.getMethod());
		
		logger.info("ip={}", request.getRemoteAddr());
		
		logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		
		logger.info("arg={}", joinPoint.getArgs());
	}
	
	@After("log()")
	public void doAfter() {
		logger.info("22222222");
	}
	
	@AfterReturning(returning = "object", pointcut = "log()")
	public void doAfterReturning(Object object) {
		logger.info("response={}", object);
	}
	
}
