package com.acvr.kafka.springboot_kafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "kafka_topic",groupId = "myGroup")
    public void consume(String message) {
        log.info(String.format("Message receved -> %s",message));
        System.out.println("Consumed message: " + message);
    }

}

