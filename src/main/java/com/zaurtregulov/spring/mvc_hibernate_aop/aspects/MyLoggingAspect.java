package com.zaurtregulov.spring.mvc_hibernate_aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {


    @Around("execution(* com.zaurtregulov.spring.mvc_hibernate_aop.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        String methodName = proceedingJoinPoint.getSignature().getName();
        System.out.println("Начал работу " + methodName);
        Object methodResult = proceedingJoinPoint.proceed();
        System.out.println("Начал работу " + methodName);
        return methodResult;
    }

}
