package com.luv2code.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    private Logger log = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
    private void forControllerPackage() { }

    @Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
    private void forServicePackage() { }

    @Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
    private void forDaoPackage() { }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

//    @Pointcut("execution(* *(..))")
//    private void testAll() {}

    @Before("forAppFlow()")
    public void before(JoinPoint jP) {
        String theMethod = jP.getSignature().toShortString();
        log.info("===> in @Before: calling method: " + theMethod);

        Object[] args = jP.getArgs();
        for(Object arg : args) {
            log.info("===> Argument: " + arg);
        }
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint jP, Object result) {
        String theMethod = jP.getSignature().toShortString();
        log.info("===> in @AfterReturning: from method: " + theMethod);

        log.info("===> result : " + result);
    }
}
