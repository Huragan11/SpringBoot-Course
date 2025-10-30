package com.huragan11.aopdemo.dao;

import com.huragan11.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;
    private String serviceCode;

    @Override
    public void addAccount(Account account,  boolean vip) {
        System.out.println(getClass().getSimpleName());
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass());
        return false;
    }

    public String getName() {
        System.out.println("getName");
        return name;
    }

    public void setName(String name) {
        System.out.println("setName");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println("getServiceCode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("setServiceCode");
        this.serviceCode = serviceCode;
    }
}
