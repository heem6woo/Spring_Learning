package com.heemcode.sprincoredemo.rest;

import com.heemcode.sprincoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public DemoRestController(@Qualifier("cricketCoach") Coach theCoach, @Qualifier("cricketCoach") Coach theOtherCoach) {

        System.out.println("In Constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theOtherCoach;
        //System.out.println("In Constructor: " + getClass().getSimpleName());
    }
    /*
    public DemoRestController(Coach theCoach) {
        myCoach = theCoach;
    }

     */
    @GetMapping("/dailyworkout")
    public String getWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String getCheck() {
        return "Is this singlenton bean " + (myCoach == anotherCoach);
    }


}
