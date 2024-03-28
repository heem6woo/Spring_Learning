package com.heem.aopdemo.dao;

import com.heem.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    public List<Account> findAccounts();

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);


}
