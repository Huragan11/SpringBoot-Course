package com.huragan11.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {


//    @Before("execution(public void addAccount())")
//    @Before("execution(public void com.huragan11.aopdemo.dao.AccountDAO.addAccount())")
//    @Before("execution(public void add*)")
//    @Before("execution(void add*)")
    @Before("execution(* add*(com.huragan11.aopdemo.Account))")
    public void beforeAddAccount() {
        System.out.println("\n =====>>>>> Executing @Before advice");
    }
}
