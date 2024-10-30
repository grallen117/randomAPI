package com.randomfacts.randomAPI.controller;

import com.randomfacts.randomAPI.service.RandomAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v2/facts")
public class RandomFactController {

    private final RandomAPIService randomApiService;

    @Autowired
    public RandomFactController(RandomAPIService randomApiService) {
        this.randomApiService = randomApiService;
    }

    @GetMapping("/random")
    public String getRandomFact() {
        return randomApiService.getRandomFact();
    }
    @GetMapping("/today")
    public String getTodayFact() {
        return randomApiService.getTodaysRandomFact();
    }

}
