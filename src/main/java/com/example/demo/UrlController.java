package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/")
public class UrlController {
    private final UrlService urlService;

    @PostMapping
    public String add(@RequestBody Url url){
        return urlService.add(url).getShortName();
    }

    @GetMapping("/{shortName}")
    public ResponseEntity<String> getOne(@PathVariable String shortName){
        val url = urlService.findByShortName(shortName);
        if(url.isPresent()){
            return ResponseEntity.ok(url.get());
        }
        return ResponseEntity.notFound().build();
    }

}