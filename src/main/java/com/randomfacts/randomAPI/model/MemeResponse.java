package com.randomfacts.randomAPI.model;

import java.util.List;

public class MemeResponse {

    private List<String> imageUrls;

    public MemeResponse(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

}
