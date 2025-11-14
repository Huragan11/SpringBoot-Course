package com.huragan11.aopdemo.aspect;

import com.huragan11.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.huragan11.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint pjp) throws Throwable {

        String method = pjp.getSignature().toShortString();
        System.out.println("\n========>>> Executing @Around Advice " + method);

        long begin = System.nanoTime();

        Object result;
        try {
            result = pjp.proceed();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

        long end = System.nanoTime();

        long duration = end - begin;

        System.out.println("\n========>>> Duration: " + duration + " nanoseconds");
        return result;
    }

    @After("execution(* com.huragan11.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n========>>> Executing @After (finally) Advice " + method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.huragan11.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n========>>> Executing @AfterThrowing Advice " + method);
        System.out.println("\n========>>> Exception: " + theExc);
    }


    @AfterReturning(
            pointcut = "execution(* com.huragan11.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n========>>> Executing @AfterReturning Advice " + method);
        System.out.println("\n========>>> result: " + result);

        convertAccountNamesToUpperCase(result);

        System.out.println("\n========>>> result: " + result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account account : result) {
            account.setName(account.getName().toUpperCase());
        }
    }

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
