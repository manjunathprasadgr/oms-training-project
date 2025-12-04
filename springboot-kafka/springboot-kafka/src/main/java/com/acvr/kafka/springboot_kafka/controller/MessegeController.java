package com.acvr.kafka.springboot_kafka.controller;

import com.acvr.kafka.springboot_kafka.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//http:localhost:8080/api/v1/kafka/publish?messege=hello world
@RestController
@RequestMapping("/api/v1/kafka")
public class MessegeController {
    private KafkaProducer kafkaProducer;

    public MessegeController(KafkaProducer kafkaProducer) {
       this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok().body("Message published");
    }
}
