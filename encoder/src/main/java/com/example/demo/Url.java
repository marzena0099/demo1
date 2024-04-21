package com.example.demo;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;
import java.util.UUID;

@Data
@Table
public class Url {

    @PrimaryKey
    private UUID id;

    String originName;

    String shortName;

    Instant created;
}