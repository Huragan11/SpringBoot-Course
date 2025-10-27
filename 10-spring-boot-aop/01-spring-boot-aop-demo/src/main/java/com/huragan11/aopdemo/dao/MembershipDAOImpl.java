package com.huragan11.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements  MembershipDAO {
    @Override
    public void addAccount() {
        System.out.println(getClass().getSimpleName());
    }

    @Override
    public boolean addAnything() {
        return true;
    }
}
