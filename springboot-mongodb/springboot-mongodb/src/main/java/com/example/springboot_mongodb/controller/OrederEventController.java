package com.example.springboot_mongodb.controller;

import com.example.springboot_mongodb.dto.Events;
import com.example.springboot_mongodb.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrederEventController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/addOrder")
    public String saveOrder(@RequestBody Events events){
        orderRepository.save(events);
        return "Order Saved wih id : "+events.getId();
    }

    @GetMapping("/findAllOrders")
    public List<Events> getAllOrders(){
        return orderRepository.findAll();
    }

    @GetMapping("/findAllOrders/{id}")
    public Optional<Events> findOrderById(@PathVariable String id){
        return orderRepository.findById(String.valueOf(Integer.valueOf(id)));
    }

}
