package com.example.demo;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UrlService {
    private final UrlRepository urlRepository;


    @Transactional
    public Urls add(@RequestBody Urls urls){
        return urlRepository.save(urls);
    }

    @Transactional
    public Optional<Urls> findById(Long id) {
        return urlRepository.findById(id);
    }
}