package com.example.aw20251102_2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class TopCoinApiResponse {
        private String id;
        private String symbol;
        private String name;
        private String image;

        @JsonProperty("current_price")
        private BigDecimal currentPrice;

        @JsonProperty("market_cap")
        private BigDecimal marketCap;

        @JsonProperty("market_cap_rank")
        private Integer marketCapRank;

        @JsonProperty("fully_diluted_valuation")
        private BigDecimal fullyDilutedValuation;

        @JsonProperty("total_volume")
        private BigDecimal totalVolume;

        @JsonProperty("high_24h")
        private BigDecimal high24h;

        @JsonProperty("low_24h")
        private BigDecimal low24h;

        @JsonProperty("price_change_24h")
        private BigDecimal priceChange24h;

        @JsonProperty("price_change_percentage_24h")
        private BigDecimal priceChangePercentage24h;

        @JsonProperty("market_cap_change_24h")
        private BigDecimal marketCapChange24h;

        @JsonProperty("market_cap_change_percentage_24h")
        private BigDecimal marketCapChangePercentage24h;

        @JsonProperty("circulating_supply")
        private BigDecimal circulatingSupply;

        @JsonProperty("total_supply")
        private BigDecimal totalSupply;

        @JsonProperty("max_supply")
        private BigDecimal maxSupply;

        private BigDecimal ath;

        @JsonProperty("ath_change_percentage")
        private BigDecimal athChangePercentage;

        @JsonProperty("ath_date")
        private String athDate;

        private BigDecimal atl;

        @JsonProperty("atl_change_percentage")
        private BigDecimal atlChangePercentage;

        @JsonProperty("atl_date")
        private String atlDate;

        private Roi roi;

        @JsonProperty("last_updated")
        private String lastUpdated;

        public static class Roi {
            private BigDecimal times;
            private String currency;
            private BigDecimal percentage;

            public BigDecimal getTimes() {
                return times;
            }

            public String getCurrency() {
                return currency;
            }

            public BigDecimal getPercentage() {
                return percentage;
            }
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

    public String getImage() {
        return image;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public BigDecimal getMarketCap() {
        return marketCap;
    }

    public Integer getMarketCapRank() {
        return marketCapRank;
    }

    public BigDecimal getFullyDilutedValuation() {
        return fullyDilutedValuation;
    }

    public BigDecimal getTotalVolume() {
        return totalVolume;
    }

    public BigDecimal getHigh24h() {
        return high24h;
    }

    public BigDecimal getLow24h() {
        return low24h;
    }

    public BigDecimal getPriceChange24h() {
        return priceChange24h;
    }

    public BigDecimal getPriceChangePercentage24h() {
        return priceChangePercentage24h;
    }

    public BigDecimal getMarketCapChange24h() {
        return marketCapChange24h;
    }

    public BigDecimal getMarketCapChangePercentage24h() {
        return marketCapChangePercentage24h;
    }

    public BigDecimal getCirculatingSupply() {
        return circulatingSupply;
    }

    public BigDecimal getTotalSupply() {
        return totalSupply;
    }

    public BigDecimal getMaxSupply() {
        return maxSupply;
    }

    public BigDecimal getAth() {
        return ath;
    }

    public BigDecimal getAthChangePercentage() {
        return athChangePercentage;
    }

    public String getAthDate() {
        return athDate;
    }

    public BigDecimal getAtl() {
        return atl;
    }

    public BigDecimal getAtlChangePercentage() {
        return atlChangePercentage;
    }

    public String getAtlDate() {
        return atlDate;
    }

    public Roi getRoi() {
        return roi;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }
}

