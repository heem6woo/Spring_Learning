package com.heemcode.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@SpringBootApplication (
		scanBasePackages = {"com.heemcode._01_java_spring_core_constructor_injection",
		"com.heemcode.util"}
)

 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
