package com.example.aw20251102_1.model;

import java.util.Objects;

public class CacheKey {
    private String name;
    private Integer min;
    private Integer max;

    public CacheKey(String name) {
        this.name = name;
    }

    public CacheKey(String name, Integer min, Integer max) {
        this.name = name;
        this.min = min;
        this.max = max;
    }

    public String getName() {
        return name;
    }

    public Integer getMin() {
        return min;
    }

    public Integer getMax() {
        return max;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CacheKey key = (CacheKey) o;
        return Objects.equals(name, key.name) && Objects.equals(min, key.min) && Objects.equals(max, key.max);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, min, max);
    }
}