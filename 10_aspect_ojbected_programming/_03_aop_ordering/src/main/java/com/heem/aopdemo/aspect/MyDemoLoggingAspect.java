package com.heem.aopdemo.aspect;

import com.heem.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.heem.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n====>> Executing @Around(before proceed) on method: " + method);
        // before
        Object result = null;
        long begin = System.currentTimeMillis();
        try {
            result = theProceedingJoinPoint.proceed();

        } catch (Exception exc) {
            System.out.println("Exception is caught: ");
            //result = "ERROR";
            // rethrow exception

            throw exc;
        }
        // after
        long end = System.currentTimeMillis();

        long duration = end - begin;

        System.out.println("\n=====> Duration: " + duration + " milliseconds");


        return result;
    }



    @After("execution(* com.heem.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
        // which method
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n====>> Executing @After (finally) on method: + " + method);


    }

    @AfterThrowing(
            pointcut = "execution(* com.heem.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(
            JoinPoint theJoinPoint, Throwable theExc) {

        // print
        // which method
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n====>> Executing @AfterThrowing on method: + " + method);

        // results
        System.out.println("\n====>> Exception is: " + theExc.getMessage());


    }


    @AfterReturning(
            pointcut = "execution(* com.heem.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

        // which method
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n====>> Executing @AfterReturning on method: + " + method);

        // results
        System.out.println("\n====>> result is: " + result);

        // modify result list

        if (!result.isEmpty()) {
            Account temp = result.get(0);

            temp.setName("Heem");

        }

        // results
        System.out.println("\n====>> Modified result is: " + result);


    }


    @Before("com.heem.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJointPoint) {
        System.out.println("\n=====>>> Executing @Before advice on method");

        // display the method signature

        MethodSignature methodSignature = (MethodSignature) theJointPoint.getSignature();

        System.out.println("Method: " + methodSignature);


        // display method arguments

        Object[] args = theJointPoint.getArgs();

        for(Object arg: args) {
            System.out.println(arg);

            // downcast and print specific stuff
            if (arg instanceof Account) {
                Account theAccount = (Account) arg;
                System.out.println("Account Name: " + theAccount.getName());
                System.out.println("Account Level: " + theAccount.getLevel());

            }
            System.out.println(arg.getClass());
        }
    }

}











