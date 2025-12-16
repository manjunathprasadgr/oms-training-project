package com.acvr.order.repository;

import com.acvr.order.event.EventDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<EventDocument, String> {
}
