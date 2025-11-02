package com.huragan11.aopdemo.aspect;

import com.huragan11.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.huragan11.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccount(JoinPoint joinPoint) {
        System.out.println("\n =====>>>>> Executing @Before advice");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method Signature: " + signature);

        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            System.out.println("arg: " + arg);

            if (arg instanceof Account) {
                Account account = (Account) arg;
                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());

            }
        }

    }
}
