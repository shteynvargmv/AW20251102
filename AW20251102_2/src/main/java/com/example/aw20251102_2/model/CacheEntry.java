package com.example.aw20251102_2.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CacheEntry {

    private CacheKey cacheKey;
    private String createTimestamp;
    private long timeToExp;
    private int used;

    public CacheEntry(CacheKey cacheKey, CacheData cacheData, long timeToExp) {
        this.cacheKey = cacheKey;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.createTimestamp = sdf.format(new Date(cacheData.getTime()));
        this.timeToExp = timeToExp;
        this.used = cacheData.getUsed();
    }

    public CacheKey getCacheKey() {
        return cacheKey;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public long getTimeToExp() {
        return timeToExp;
    }

    public int getUsed() {
        return used;
    }
}
