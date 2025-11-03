package com.example.aw20251102_1.model;

public class CacheData {
    CountryApiResponse[] data;
    long time;
    int used;

    public CacheData(CountryApiResponse[] data) {
        this.data = data;
        this.time = System.currentTimeMillis();
        this.used = 0;
    }

    boolean isExpired(long timeToLive) {
        return (System.currentTimeMillis() - this.time) > timeToLive;
    }

    public void addUsage(){
        this.used += 1;
    }

    public int getUsed() {
        return used;
    }

    public long getTime() {
        return time;
    }

    public CountryApiResponse[] getData() {
        return data;
    }
}
