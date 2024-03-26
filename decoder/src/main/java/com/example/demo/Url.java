package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table
@Entity
public class Url {

    @Id
    @GeneratedValue
    Long id;

    String originName;

    @Column(unique = true)
    String shortName;


}