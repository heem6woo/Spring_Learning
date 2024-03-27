package com.heem._01_aop;

import com.heem._01_aop.dao.AccountDAO;
import com.heem._01_aop.dao.MembershipDAO;
import com.heem._01_aop.entity.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        return runner -> {

            demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);

        };
    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        theAccountDAO.addAccount(new Account(), true);

        theMembershipDAO.addSillyMember();


    }


}
