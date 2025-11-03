package com.example.aw20251102_4.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Recipe {
    private Long id;
    private String title;
    private String image;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getImageType() {
        return imageType;
    }

    @JsonProperty("imageType")
    private String imageType;
}
