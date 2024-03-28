package com.heem.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    // setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());


    // setup pointcut declarations
    @Pointcut("execution(* com.heem.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage() {}
    // do the same for service and dao
    @Pointcut("execution(* com.heem.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.heem.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint) {
        // display method we are calling

        String method = theJoinPoint.getSignature().toShortString();

        myLogger.info("\n=====>> in @Before: calling method: " + method);

        // display the arguments to the method
        Object[] args = theJoinPoint.getArgs();
        for (Object arg: args) {
            myLogger.info("\n=====>> passed arguments: " + arg);
        }


    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult"
    )
    public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
        // display method we are returning from

        String method = theJoinPoint.getSignature().toShortString();

        myLogger.info("\n=====>> in @After: calling method: " + method);

        // display data returned

        myLogger.info("\n=====>> result: " + theResult);

    }

}
