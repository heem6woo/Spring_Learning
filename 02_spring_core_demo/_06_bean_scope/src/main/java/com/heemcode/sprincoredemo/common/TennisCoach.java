package com.heemcode.sprincoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {


    @Override
    public String getDailyWorkout() {
        return "Practice swing for 1hr";


    }

    public TennisCoach() {
        System.out.println("In Constructor " + getClass().getSimpleName());
    }
}
