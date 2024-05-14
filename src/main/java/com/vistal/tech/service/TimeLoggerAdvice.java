package com.vistal.tech.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeLoggerAdvice {
	
	
	@Around("execution(* com.vistal.tech.service.AopMagicService.*(..))")
    // Method
    public Object  commonLogic(ProceedingJoinPoint proceedingJoinPoint)
        throws Throwable  {
		String methodName=proceedingJoinPoint.getSignature().getName();
		long starttime= System.currentTimeMillis();
		Object result=proceedingJoinPoint.proceed();
		long endtime= System.currentTimeMillis();
		System.out.println("Total time taken by method "+methodName+" is = "+(endtime-starttime));
		return result;
	}

}
