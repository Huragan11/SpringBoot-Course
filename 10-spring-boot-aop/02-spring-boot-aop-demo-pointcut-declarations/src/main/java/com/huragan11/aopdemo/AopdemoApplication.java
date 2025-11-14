package com.huragan11.aopdemo;

import com.huragan11.aopdemo.dao.AccountDAO;
import com.huragan11.aopdemo.dao.MembershipDAO;
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
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        return runner -> {
//            demoTheBeforeAdvice(accountDAO, membershipDAO);
//        demoAfterReturnAdvice(accountDAO);
//            demoTheAfterThrowingAdvice(accountDAO);
        demoTheAfterAdvice(accountDAO);

        };


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
