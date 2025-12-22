package com.acvr.order.event;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection= "eventDocuments")
public class EventDocument {
    @Id
    private long id;
    private String type;
    private String payload;
    private long occurredAt;
}
