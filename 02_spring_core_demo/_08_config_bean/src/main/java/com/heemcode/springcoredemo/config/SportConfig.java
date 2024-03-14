package com.heemcode.springcoredemo.config;

import com.heemcode.springcoredemo.common.Coach;
import com.heemcode.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <pre>
 *     Configuring using Class with Annotation @Configuration
 *     Set Bean using @Bean can take third-party bean
 * </pre>
 */
@Configuration
public class SportConfig {

    /*
    Can Custom bean Id
     */
    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();

    }
}
