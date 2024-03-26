package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class UrlController {
    private final UrlService urlService;

    @PostMapping("/encode")
    public String add(@RequestBody Url url){
        return urlService.add(url).getShortName();
    }

}