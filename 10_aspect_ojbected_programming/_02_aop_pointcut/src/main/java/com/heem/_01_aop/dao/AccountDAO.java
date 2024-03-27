package com.heem._01_aop.dao;

import com.heem._01_aop.entity.Account;

public interface AccountDAO {

    void addAccount(Account account, boolean vipFlag);

    public String getName() ;

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);


}
