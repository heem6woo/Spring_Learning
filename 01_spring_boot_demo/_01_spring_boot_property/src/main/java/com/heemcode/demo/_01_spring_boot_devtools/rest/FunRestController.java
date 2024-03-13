package com.heemcode.demo._01_spring_boot_devtools.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${couch.name}")
    private String couchName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeaminfo() {
        return "Couch: " + couchName + " Team: " + teamName;
    }

    @GetMapping("/test")
    public String getTest() {
        return "test: ";
    }

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }

    @GetMapping("/today")
    public String getToday() {
        return " Today is your lucky day!";

    }
}
