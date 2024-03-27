package com.heem._01_aop.dao;

import com.heem._01_aop.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;

    private String serviceCode;

    public String getName() {
        System.out.println(getClass() + "is getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + "is setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + "is getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + "is setServiceCode()");
        this.serviceCode = serviceCode;
    }

    @Override
    public void addAccount(Account account,boolean vipFlag) {
        System.out.println(getClass() + ": Doing my db work: Adding an account");
    }
}
