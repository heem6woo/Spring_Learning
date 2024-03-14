package com.heemcode.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements  Coach{


    @Override
    public String getDailyWorkout() {
        return "Practice batting for 30 mins";
    }

    public BaseballCoach() {
        System.out.println("In Constructor " + getClass().getSimpleName());
    }
}
