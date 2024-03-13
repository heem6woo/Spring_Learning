package com.heemcode.sprincoredemo.common;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
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

    public CricketCoach() {
        System.out.println("In Constructor " + getClass().getSimpleName());
    }
}

