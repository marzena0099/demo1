package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/")
public class UrlController {
    private final UrlService urlService;



    @PostMapping
    public Urls add(@RequestBody Urls url){
        return urlService.add(url);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Urls> getOne(@PathVariable Long id){
        Optional<Urls> url = urlService.findById(id);
        if(url.isPresent()){
            return ResponseEntity.ok(url.get());
        }
        return ResponseEntity.notFound().build();
    }

}