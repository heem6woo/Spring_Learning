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

    @Before("execution(* com.heem._01_aop.dao.*.*(*,..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n========>> Executing @Before advice on addAccount() ");
    }



}
