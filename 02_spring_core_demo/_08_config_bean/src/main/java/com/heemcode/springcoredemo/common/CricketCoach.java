package com.heemcode.springcoredemo.common;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// set class as a bean
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice bowling for 15mins! ^^";
    }

    /*
    @PostConstruct
    public void doStuffPostConstruct() {
        System.out.println("This message is sent after Construction " + getClass().getSimpleName());
    }

    @PreDestroy
    public void doStuffPreDestroy() {
        System.out.println("This is dying message.");
    }


     */
    public CricketCoach() {
        System.out.println("In Constructor " + getClass().getSimpleName());
    }
}

