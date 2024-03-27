package com.heem._01_aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class DemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Bean advice

    //@Before("execution(public void addAccount())")

    // match all method staring with add

    @Pointcut("execution(* com.heem._01_aop.dao.*.*(..))")
    private void forDaoPackage() {}

    // create a pointcut for getter methods

    @Pointcut("execution(* com.heem._01_aop.dao.*.get*(..))")
    private void getter() {}

    // create a pointcut for setter methods
    @Pointcut("execution(* com.heem._01_aop.dao.*.set*(..))")
    private void setter() {}

    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {}


    // what is the execution order of Before advice

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n========>> Executing @Before advice on addAccount() ");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performAPI() {
        System.out.println("\n========>> Executing Performing API ");

    }







}
