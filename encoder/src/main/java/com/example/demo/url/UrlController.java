package com.example.demo.url;

import com.example.demo.prohibited.ProhibitedService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UrlController {
    private final UrlService urlService;
    private final ProhibitedService prohibitedService;

    @PostMapping("/encode")
    public ResponseEntity<String> add(@RequestBody Url url) {
        if (prohibitedService.isProhibitedWord(url.originName)) {
            return ResponseEntity.badRequest().body("is prohibitied");
        }
        return ResponseEntity.ok(urlService.add(url).getShortName());
    }
}