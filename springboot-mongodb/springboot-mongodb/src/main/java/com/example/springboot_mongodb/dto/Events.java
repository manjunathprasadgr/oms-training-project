package com.example.springboot_mongodb.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Document(collection = "events")
public class Events {
    @Id
    private String id;
    private String event;

}
