package com.huragan11.aopdemo.dao;

import com.huragan11.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account account,  boolean vip) {
        System.out.println(getClass().getSimpleName());
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass());
        return false;
    }
}
