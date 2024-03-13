package com.heemcode.sprincoredemo.common;


import org.springframework.stereotype.Component;

// set class as a bean
@Component
public class CricketCoach implements Coach {


    @Override
    public String getDailyWorkout() {
        return "Practice bowling for 15mins!";
    }
}
