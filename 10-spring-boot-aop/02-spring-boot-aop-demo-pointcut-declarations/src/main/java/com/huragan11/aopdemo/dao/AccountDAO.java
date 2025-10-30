package com.huragan11.aopdemo.dao;

import com.huragan11.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account account, boolean vip);
    boolean doWork();

}
