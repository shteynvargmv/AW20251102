package com.example.aw20251102_2.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CoinPriceApi {
    public String id;
    public String symbol;
    public String name;
    public Map<String, BigDecimal> currentPrice;

    public CoinPriceApi(String id, String symbol, String name, Map<String,BigDecimal> currentPrice ) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.currentPrice = currentPrice;
    }

    public String getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public Map<String, BigDecimal> getCurrentPrice() {
        return currentPrice;
    }
}
