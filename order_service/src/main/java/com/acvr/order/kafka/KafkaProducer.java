package com.acvr.order.kafka;

import com.acvr.order.dto.OrderCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, OrderCreated> template;


    public void send(OrderCreated orderCreated) {
        CompletableFuture<SendResult<String, OrderCreated>> future = template.send("orders", UUID.randomUUID().toString(),orderCreated);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + orderCreated +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        orderCreated + "] due to : " + ex.getMessage());
            }
        });
    }
}
