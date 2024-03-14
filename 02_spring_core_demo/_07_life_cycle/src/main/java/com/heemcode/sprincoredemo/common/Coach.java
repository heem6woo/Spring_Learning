package com.heemcode.sprincoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public interface Coach {

    String getDailyWorkout();

    @PostConstruct
    default void doStuffPostConstruct() {
        System.out.println("This message is from baby " + getClass().getSimpleName());
    }

    @PreDestroy
    default void dosStuffPreDestroy(){
        System.out.println("This message is dying message from " + getClass().getSimpleName());
    }

}
