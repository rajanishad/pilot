package com.core.pilot.adapter.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class FirstDocument {

    @Id
    private String id;

    private String name;
}
