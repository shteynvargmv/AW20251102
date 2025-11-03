package com.example.aw20251102_3.model;

public class CacheData {
    Object data;
    long time;
    int used;

    public CacheData(Object data) {
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

    public Object getData() {
        return data;
    }
}
