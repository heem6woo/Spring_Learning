package com.heem.kafkademo.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMEssage(String msg) {

        log.info(String.format("Sending message to heemin Topic:: %s", msg));
        kafkaTemplate.send("heemin", msg);
    }


}
