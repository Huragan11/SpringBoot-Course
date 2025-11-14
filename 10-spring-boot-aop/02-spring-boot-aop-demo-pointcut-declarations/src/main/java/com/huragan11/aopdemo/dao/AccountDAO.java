package com.huragan11.aopdemo.dao;

import com.huragan11.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    List<Account> findAccounts();

    void addAccount(Account account, boolean vip);

    boolean doWork();

    String getName();

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);

    List<Account> findAccounts(boolean tripWire);
}
