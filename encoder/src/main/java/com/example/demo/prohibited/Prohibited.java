package com.example.demo.prohibited;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Data
@Table
public class Prohibited {

    @PrimaryKey
    private UUID id;

    String word;
}