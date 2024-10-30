package com.randomfacts.randomAPI.controller;

import com.randomfacts.randomAPI.model.MemeResponse;
import com.randomfacts.randomAPI.service.RandomAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/get_memes")
public class RandomMemesController {

    private final RandomAPIService randomApiService;

    @Autowired
    public RandomMemesController(RandomAPIService randomApiService) {
        this.randomApiService = randomApiService;
    }

    @GetMapping("/random")
    public MemeResponse getRandomMemes() {
        List<String> memeUrls = randomApiService.getRandomMemes();
        return new MemeResponse(memeUrls);
    }


}
