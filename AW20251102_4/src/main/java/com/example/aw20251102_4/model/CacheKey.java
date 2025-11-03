package com.example.aw20251102_4.model;

import java.util.Map;
import java.util.Objects;

public class CacheKey{
    private String service;
    private Map<String,String> params;

    public CacheKey(String service, Map<String, String> params) {
        this.service = service;
        this.params = params;
    }

    public String getService() {
        return service;
    }

    public Map<String, String> getParams() {
        return params;
    }

    @Override
    public String toString() {
        return  "service='" + service + '\'' +
                ", params=" + params;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CacheKey cacheKey = (CacheKey) o;
        return Objects.equals(service, cacheKey.service) && Objects.equals(params, cacheKey.params);
    }

    @Override
    public int hashCode() {
        return Objects.hash(service, params);
    }
}
