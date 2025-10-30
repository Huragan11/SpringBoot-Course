package com.huragan11.aopdemo.dao;

import com.huragan11.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account account, boolean vip);

    boolean doWork();

    String getName();

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);
}
