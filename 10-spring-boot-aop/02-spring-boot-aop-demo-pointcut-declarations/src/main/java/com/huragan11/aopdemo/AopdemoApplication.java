package com.huragan11.aopdemo;

import com.huragan11.aopdemo.dao.AccountDAO;
import com.huragan11.aopdemo.dao.MembershipDAO;
import com.huragan11.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficFortuneService trafficFortuneService) {
        return runner -> {
//            demoTheBeforeAdvice(accountDAO, membershipDAO);
//        demoAfterReturnAdvice(accountDAO);
//            demoTheAfterThrowingAdvice(accountDAO);
//        demoTheAfterAdvice(accountDAO);
//            demoTheAroundAdvice(trafficFortuneService);
//            demoTheAroundAdviceHandleException(trafficFortuneService);
            demoTheAroundAdviceRethrowException(trafficFortuneService);

        };


    }

    private void demoTheAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {
        System.out.println("demoTheAroundAdviceRethrowException");
        boolean tripWire = true;
        String data = trafficFortuneService.getFortune(tripWire);
        System.out.println(data);
    }

    private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
        System.out.println("demoTheAroundAdviceHandleException");
        boolean tripWire = true;
        String data = trafficFortuneService.getFortune(tripWire);
        System.out.println(data);
    }

    private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
        System.out.println("demoTheAroundAdvice");
        System.out.println(trafficFortuneService.getFortune());
    }

    private void demoTheAfterAdvice(AccountDAO accountDAO) {
        List<Account> theAccounts = null;

        try {
            theAccounts = accountDAO.findAccounts(false);
        } catch (Exception ex) {
            System.out.println("EXCEPTION! ");
        }
        System.out.println("After Return Advice");
        System.out.println(theAccounts);
    }

    private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
        List<Account> theAccounts = null;

        try {
            theAccounts = accountDAO.findAccounts(true);
        } catch (Exception ex) {
            System.out.println("EXCEPTION! " + ex);
        }
        System.out.println("After Return Advice");
        System.out.println(theAccounts);
    }

    private void demoAfterReturnAdvice(AccountDAO accountDAO) {
        List<Account> theAccounts = accountDAO.findAccounts();

        System.out.println("After Return Advice");
        System.out.println(theAccounts);
    }

    private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        Account account = new Account();
        account.setName("test");
        account.setLevel("Gold");
        accountDAO.addAccount(account, true);
        accountDAO.doWork();

        accountDAO.setName("adad");
        accountDAO.setServiceCode("adaddd");

        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();

        membershipDAO.addAccount();
        membershipDAO.goToSleep();
    }
}
