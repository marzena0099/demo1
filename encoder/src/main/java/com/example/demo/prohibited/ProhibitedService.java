package com.example.demo.prohibited;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class ProhibitedService {
    private final ProhibitedRepository prohibitedRepository;

    public String isProhibitedWord(String url){
        return
                Arrays.stream(url.split("/"))
                        .filter(word->prohibitedRepository.existsByWord(word))
                        .findFirst()
                        .orElse(null);
    }
}