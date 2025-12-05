package com.example.springboot_mongodb.repository;

import com.example.springboot_mongodb.dto.Events;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Events,String> {
}
