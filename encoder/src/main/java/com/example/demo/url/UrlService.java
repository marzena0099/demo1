package com.example.demo.url;

import com.datastax.driver.core.utils.UUIDs;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Instant;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class UrlService {
    private final UrlRepository urlRepository;
    private final static int NUMBER_OF_SECONDS_FOR_30_DAYS = 60 * 60 * 24 * 30;

    public Url add(@RequestBody Url url) {
        url.setShortName(random());
        url.setId(UUIDs.timeBased());
        url.setCreated(Instant.now());
        return urlRepository.save(url);
    }


    private String random() {
        return RandomStringUtils.randomAlphabetic(5);

    }

    public Optional<String> findByShortName(String shortName) {
        return urlRepository
                .findByShortName(shortName)
                .map(url -> url.getOriginName());
    }

    @Scheduled(fixedRate = 10, timeUnit = TimeUnit.SECONDS)
    public void cleaner() {
        urlRepository.deleteAll(
                urlRepository.findAllByCreatedLessThan(Instant.now().minusSeconds(NUMBER_OF_SECONDS_FOR_30_DAYS)));
    }
}