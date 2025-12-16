package com.acvr.order.dto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderDto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long orderId;
    private String orderDate;
    private String costomerName;
    private String productName;
    private double amount;
}
