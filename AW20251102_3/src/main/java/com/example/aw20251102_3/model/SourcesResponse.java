package com.example.aw20251102_3.model;

import java.util.List;

public class SourcesResponse {
    private String status;
    private List<NewsSource> sources;

    public String getStatus() {
        return status;
    }

    public List<NewsSource> getSources() {
        return sources;
    }
}