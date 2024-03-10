package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table
@Entity
public class Urls {

    @Id
    @GeneratedValue
    Long id;

    String name;

}