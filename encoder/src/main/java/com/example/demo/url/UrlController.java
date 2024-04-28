package com.example.demo.url;

import com.example.demo.prohibited.ProhibitedService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UrlController {
    private final UrlService urlService;
    private final ProhibitedService prohibitedService;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/encode")
    public ResponseEntity<String> add(@RequestBody Url url) {
        String prohibitedWord = prohibitedService.isProhibitedWord(url.originName);
        if (prohibitedWord != null) {
            kafkaTemplate.send("my-topic",
                    String.format("date: %s, ulr: %s, word: %s",
                            Instant.now().toString(),
                            url.originName,
                            prohibitedWord));
            return ResponseEntity.badRequest().body("is prohibitied");
        }
        return ResponseEntity.ok(urlService.add(url).getShortName());
    }
}