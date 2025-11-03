package com.example.aw20251102_2.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CryptoCompareResponse {
    private List<CryptoResponse> cryptos;
    private Map<String, String> comparison;
    private BigDecimal totalMarketCap;
    private static final String DEF_CURR = "usd";

    public CryptoCompareResponse(){
        this.cryptos = new ArrayList<>();
        this.comparison = new HashMap<>();
        this.totalMarketCap = BigDecimal.valueOf(0);
    }

    public void add(CoinApiResponse coin) {
        this.totalMarketCapAdd(coin.getMarketData().getMarketCap().get(DEF_CURR));
        this.cryptos.add(new CryptoResponse(coin));
        this.compare();
    }

    public void compare() {
        if (this.cryptos.size() == 2) {
            String name1 = cryptos.get(0).getName();
            String name2 = cryptos.get(1).getName();
            comparison("Current price",
                    name1, cryptos.get(0).getCurrentPrice(),
                    name2, cryptos.get(1).getCurrentPrice());
            comparison("Price Change 24h",
                    name1, cryptos.get(0).getPriceChange24h().abs(),
                    name2, cryptos.get(1).getPriceChange24h().abs());
            comparison("Price Change Percentage 24h",
                    name1, cryptos.get(0).getPriceChangePercentage24h().abs(),
                    name2, cryptos.get(1).getPriceChangePercentage24h().abs());
            comparison("Market Cap",
                    name1, cryptos.get(0).getMarketCap(),
                    name2, cryptos.get(1).getMarketCap());
            comparison("Market Cap",
                    name1, cryptos.get(0).getMarketCap(),
                    name2, cryptos.get(1).getMarketCap());

        }
    }

    public void comparison(
            String field,
            String coinName1, BigDecimal val1,
            String coinName2, BigDecimal val2) {
        String sign = "";
        if (val1.compareTo(val2) > 0) {
            sign = ">";
        } else if (val1.compareTo(val2) < 0) {
            sign = "<";
        } else {
            sign = "=";
        }
        this.comparison.put(field, field + " of " + coinName1 + " " +
                sign + " " + field + " of " + coinName2);
    }

    public void comparison(
            String field,
            String coinName1, Integer val1,
            String coinName2, Integer val2) {
        String sign = "";
        if (val1.compareTo(val2)>0) {
            sign = ">";
        } else if (val1.compareTo(val2)<0) {
            sign = "<";
        } else {
            sign = "=";
        }
        this.comparison.put(field, field + " of " + coinName1 + " " +
                sign + " " + field + " of " + coinName2);
    }

    class CryptoResponse {
        private String id;
        private String symbol;
        private String name;
        private String imageUrl;
        private BigDecimal currentPrice;
        private BigDecimal priceChange24h;
        private BigDecimal priceChangePercentage24h;
        private BigDecimal marketCap;
        private Integer marketCapRank;

        public CryptoResponse(CoinApiResponse coin) {
            this.id = coin.getId();
            this.symbol = coin.getSymbol();
            this.name = coin.getName();
            this.imageUrl = coin.getImage().getLarge();
            CoinApiResponse.MarketData marketData = coin.getMarketData();
            this.currentPrice = marketData.getCurrentPrice().get(DEF_CURR);
            this.priceChange24h = marketData.getPriceChange24h();
            this.priceChangePercentage24h = marketData.getPriceChangePercentage24h();
            this.marketCap = marketData.getMarketCap().get(DEF_CURR);
            this.marketCapRank = marketData.getMarketCapRank();
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getSymbol() {
            return symbol;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public BigDecimal getCurrentPrice() {
            return currentPrice;
        }

        public BigDecimal getPriceChange24h() {
            return priceChange24h;
        }

        public BigDecimal getPriceChangePercentage24h() {
            return priceChangePercentage24h;
        }

        public BigDecimal getMarketCap() {
            return marketCap;
        }

        public int getMarketCapRank() {
            return marketCapRank;
        }
    }

    public void totalMarketCapAdd(BigDecimal marketCap) {
        this.totalMarketCap = this.totalMarketCap.add(marketCap);
    }

    public List<CryptoResponse> getCryptos() {
        return cryptos;
    }

    public Map<String, String> getComparison() {
        return comparison;
    }

    public BigDecimal getTotalMarketCap() {
        return totalMarketCap;
    }
}

