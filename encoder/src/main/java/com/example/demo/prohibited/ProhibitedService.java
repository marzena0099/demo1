package com.example.demo.prohibited;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProhibitedService {
    private final ProhibitedRepository prohibitedRepository;

    public boolean isProhibitedWord(String url){
        return prohibitedRepository.existsByWord(url);
    }
}