package com.huragan11.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.huragan11.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Before("forDaoPackage()")
    public void beforeAddAccount() {
        System.out.println("\n =====>>>>> Executing @Before advice");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics(){
        System.out.println("\n =====>>>>> Performing API Analytics");
    }

}
