package com.acvr.order.service;

import com.acvr.order.dto.OrderDto;

import java.util.List;

public interface OrderService {
  public OrderDto  saveOrder(OrderDto order);
  public List<OrderDto> getAllOrders();
}
