package com.example.aw20251102_3.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Article {
    private Source source;
    private String author;
    private String title;
    private String description;
    private String url;

    @JsonProperty("urlToImage")
    private String urlToImage;

    @JsonProperty("publishedAt")
    private String publishedAt;

    private String content;
}