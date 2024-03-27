package com.heem._01_aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MemebershipDAOImpl implements MembershipDAO {

    @Override
    public void addSillyMember() {
        System.out.println(getClass() + ": Doing my db work: Adding an memebership account");
    }
}
