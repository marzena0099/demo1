package com.example.demo;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UrlService {
    private final UrlRepository urlRepository;

    public Url add(@RequestBody Url url){
        while(true) {
            try {
                url.setShortName(random());
                url.setId(UUID.randomUUID());
                return urlRepository.save(url);
            }
            catch(Throwable e){

            }
        }
    }



    private String random() {
       return RandomStringUtils.randomAlphabetic(5);

    }

    public Optional<String> findByShortName(String shortName) {
        return urlRepository
                .findByShortName(shortName)
                .map(url->url.getOriginName());
    }
}