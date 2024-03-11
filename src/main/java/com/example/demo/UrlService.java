package com.example.demo;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class UrlService {
    private final UrlRepository urlRepository;

    @Transactional
    public Url add(@RequestBody Url url){
        while(true) {
            try {
                url.setShortName(random());
                return urlRepository.save(url);
            }
            catch(Throwable e){

            }
        }
    }



    private String random() {
       return RandomStringUtils.randomAlphabetic(5);

    }

    @Transactional
    public Optional<String> findByShortName(String shortName) {
        return urlRepository
                .findByShortName(shortName)
                .map(url->url.getOriginName());
    }
}