package com.randomfacts.randomAPI.service;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class RandomAPIService {

    private final RestTemplate restTemplate;


    @Value("${randomapi.randomfacts.url}")
    private String randomFactsUrl;

    @Value("${randomapi.randommemes.url}")
    private String randomMemesUrl;


    public RandomAPIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getRandomFact() {
        String url = randomFactsUrl + "/api/v2/facts/random?language=en";
        System.out.println("URL = " + url);
        String response = restTemplate.getForObject(url, String.class);
        System.out.println("Response from API: " + response);

        return response;

    }

    public String getTodaysRandomFact() {
        String url = randomFactsUrl + "/api/v2/facts/today?language=en";
        System.out.println("URL = " + url);
        String response = restTemplate.getForObject(url, String.class);
        System.out.println("Response from API: " + response);
        return response;
    }

    public List<String> getRandomMemes() {
        String url = randomMemesUrl + "/get_memes";
        System.out.println("URL = " + url);
        String response = restTemplate.getForObject(url, String.class);
        System.out.println("Response from API: " + response);

        List<String> memeUrls = new ArrayList<>();
        // Parse the response as a JSONObject
        JSONObject jsonResponse = new JSONObject(response);
        //Go to the data part of the Json object
        if (jsonResponse.has("data")) {
            JSONObject dataObject = jsonResponse.getJSONObject("data");
            //Go to the memes part of the Json object (which is an array)
            if (dataObject.has("memes")) {
                JSONArray memesArray = dataObject.getJSONArray("memes");
                //Now add all these urls to the meme list
                for (int i = 0; i < memesArray.length(); i++) {
                    JSONObject memeObject = memesArray.getJSONObject(i);
                    if (memeObject.has("url")) {
                        memeUrls.add(memeObject.getString("url"));
                    }
                }
            }
        }
        return memeUrls;


    }


}
