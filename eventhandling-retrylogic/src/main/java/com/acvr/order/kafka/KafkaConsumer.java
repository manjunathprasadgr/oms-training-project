package com.acvr.order.kafka;

import com.acvr.order.dto.OrderCreated;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class KafkaConsumer {

    @RetryableTopic(attempts = "4")// 3 topic N-1
   @KafkaListener(topics="orders",groupId = "creating-order")
   public void consumeEvents(OrderCreated  order, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,@Header(KafkaHeaders.OFFSET) long offset){
       try {
           log.info("Received: {} from {} offset {}", new ObjectMapper().writeValueAsString(order), topic, offset);

           List<String> restrictedIpList = Stream.of("spider","alexa","Ram").collect(Collectors.toList());
           if (restrictedIpList.contains(order.getCostomerName())) {
               throw new RuntimeException("Invalid costumer name received!");
           }

       } catch (JsonProcessingException e) {
           e.printStackTrace();
       }

   }

    @DltHandler
    public void listenDLT(OrderCreated order, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic, @Header(KafkaHeaders.OFFSET) long offset) {
        log.info("DLT Received : {} , from {} , offset {}",order.getCostomerName(),topic,offset);
    }
}
