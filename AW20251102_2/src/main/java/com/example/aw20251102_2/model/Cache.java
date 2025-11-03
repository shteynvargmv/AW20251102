package com.example.aw20251102_2.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
    private Map<CacheKey, CacheData> cache = new ConcurrentHashMap<>();
    private long timeToLive;

    public Cache(long timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void put(CacheKey cacheKey, Object data) {
        cache.put(cacheKey, new CacheData(data));
    }

    public Object get(CacheKey cacheKey) {
        CacheData cacheData = cache.get(cacheKey);

        if (cacheData == null) {
            return null;
        }

        if (cacheData.isExpired(this.timeToLive)) {
            cache.remove(cacheKey);
            return null;
        }

        cacheData.addUsage();
        return cacheData.data;
    }

    public Boolean isEmpty(){
        if (cache.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void clear() {
        cache.clear();
    }

    public int size() {
        return cache.size();
    }

    public long getTimeToLive() {
        return timeToLive;
    }

    public Map<CacheKey, CacheData> getCache() {
        return cache;
    }
}

