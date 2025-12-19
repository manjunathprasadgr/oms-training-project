package com.acvr.order.service.impl;

import com.acvr.order.dto.OrderCreated;
import com.acvr.order.dto.OrderDto;
import com.acvr.order.event.EventDocument;
import com.acvr.order.kafka.KafkaProducer;
import com.acvr.order.repository.EventRepository;
import com.acvr.order.repository.OrderRepository;
import com.acvr.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private KafkaProducer kafkaProducer;

    @Override
    public OrderDto saveOrder(OrderDto order) {

        OrderDto savedOrder = repository.save(order);

        OrderCreated event = new OrderCreated();
        event.setOrderId(savedOrder.getOrderId());
        event.setOrderDate(savedOrder.getOrderDate());
        event.setCostomerName(savedOrder.getCostomerName());
        event.setCostomerName(savedOrder.getCostomerName());
        event.setAmount(savedOrder.getAmount());

        kafkaProducer.send(event);

        EventDocument eventDocument = new EventDocument();
        eventDocument.setId(savedOrder.getOrderId());
        eventDocument.setType("Order created");
        eventDocument.setPayload("UPDATED_SUCESFULLY");
        eventDocument.setOccurredAt(System.currentTimeMillis());


       eventRepository.save(eventDocument);


        return savedOrder;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return repository.findAll();
    }
}
