package com.example.aw20251102_3.model;

import java.util.List;

public class NewsApiResponse {
    private String status;

    private Integer totalResults;

    private List<Article> articles;

    public String getStatus() {
        return status;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public List<Article> getArticles() {
        return articles;
    }
}
