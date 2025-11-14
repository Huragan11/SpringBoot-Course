package com.huragan11.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class DemoLoggingAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Pointcut("execution(* com.huragan11.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage() {

    }
    @Pointcut("execution(* com.huragan11.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage() {

    }
    @Pointcut("execution(* com.huragan11.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage() {

    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("=====> in @Before: calling method: " + method);

        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            logger.info("=====> arg: " + arg);
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult")
    public void afterReturning(JoinPoint joinPoint, Object theResult) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("=====> in @AfterReturning: calling method: " + method);

        logger.info("=====> result: " + theResult);

    }
}



