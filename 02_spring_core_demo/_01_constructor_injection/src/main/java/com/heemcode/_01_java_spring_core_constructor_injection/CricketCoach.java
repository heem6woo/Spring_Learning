package com.heemcode._01_java_spring_core_constructor_injection;


import org.springframework.stereotype.Component;

// set class as a bean
@Component
public class CricketCoach implements Coach {


    @Override
    public String getDailyWorkout() {
        return "Practice bowling for 15mins! Now!!";
    }
}
