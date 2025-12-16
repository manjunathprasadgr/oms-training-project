package com.acvr.order.controller;

import com.acvr.order.dto.OrderDto;
import com.acvr.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/add")
    public OrderDto addOrder(@RequestBody OrderDto order){
        return service.saveOrder(order);
    }

    @GetMapping("/all")
    public List<OrderDto> getAllOrders(){
        return service.getAllOrders();
    }
}
