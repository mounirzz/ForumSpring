package com.miage.spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class ExceptionProfiler {

	@Around("@annotation(LogExceptionTime)")
	public Object logExceptionTime(ProceedingJoinPoint joinPoint) throws Throwable{
		Long start = System.currentTimeMillis();
		Object procced = joinPoint.proceed();
		Long time = System.currentTimeMillis() - start;
		log.info("Exception time of method" + joinPoint.getSignature() + "is :" + time + "ms");
		return procced ;
	}
}
