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

    @Pointcut("execution(* com.huragan11.aopdemo.dao.*.get*(..))")
    private void getter(){}
    @Pointcut("execution(* com.huragan11.aopdemo.dao.*.set*(..))")
    private void setter(){}


    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccount() {
        System.out.println("\n =====>>>>> Executing @Before advice");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n =====>>>>> Performing API Analytics");
    }

}
