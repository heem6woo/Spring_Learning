package com.heem._01_aop.dao;

import com.heem._01_aop.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    @Override
    public void addAccount(Account account,boolean vipFlag) {
        System.out.println(getClass() + ": Doing my db work: Adding an account");
    }
}
