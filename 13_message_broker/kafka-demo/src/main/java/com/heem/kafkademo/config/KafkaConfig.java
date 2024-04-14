package com.heem.kafkademo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {


    // Create new topic
    @Bean
    public NewTopic heemTopic() {
        return TopicBuilder
                .name("heemin")
                //.partitions(5)
                .build();
    }

}
