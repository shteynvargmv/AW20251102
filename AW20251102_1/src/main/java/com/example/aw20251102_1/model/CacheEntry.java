package com.example.aw20251102_1.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CacheEntry {

    private CacheKey cacheKey;
    private String createTimestamp;
    private long timeToExp;
    private CacheData cacheData;

    public CacheEntry(CacheKey cacheKey, CacheData cacheData, long timeToExp) {
        this.cacheKey = cacheKey;
        this.cacheData = cacheData;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTimestamp = sdf.format(new Date(cacheData.getTime()));
        this.createTimestamp = createTimestamp;
        this.timeToExp = timeToExp;
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

    public CacheData getCacheData() {
        return cacheData;
    }

}

