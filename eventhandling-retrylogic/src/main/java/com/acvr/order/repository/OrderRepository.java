package com.acvr.order.repository;

import com.acvr.order.dto.OrderDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderDto, Long> {

}
