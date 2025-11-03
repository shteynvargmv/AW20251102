package com.example.aw20251102_2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class CoinApiResponse {
    private String id;
    private String symbol;
    private String name;

    @JsonProperty("web_slug")
    private String webSlug;

    @JsonProperty("asset_platform_id")
    private String assetPlatformId;

    private Map<String, String> platforms;

    @JsonProperty("detail_platforms")
    private Map<String, DetailPlatform> detailPlatforms;

    @JsonProperty("block_time_in_minutes")
    private Integer blockTimeInMinutes;

    @JsonProperty("hashing_algorithm")
    private String hashingAlgorithm;

    private List<String> categories;

    @JsonProperty("preview_listing")
    private Boolean previewListing;

    @JsonProperty("public_notice")
    private String publicNotice;

    @JsonProperty("additional_notices")
    private List<String> additionalNotices;

    private Map<String, String> localization;
    private Map<String, String> description;
    private Links links;
    private Image image;

    @JsonProperty("country_origin")
    private String countryOrigin;

    @JsonProperty("genesis_date")
    private String genesisDate;

    @JsonProperty("sentiment_votes_up_percentage")
    private BigDecimal sentimentVotesUpPercentage;

    @JsonProperty("sentiment_votes_down_percentage")
    private BigDecimal sentimentVotesDownPercentage;

    @JsonProperty("watchlist_portfolio_users")
    private Long watchlistPortfolioUsers;

    @JsonProperty("market_cap_rank")
    private Integer marketCapRank;

    @JsonProperty("market_data")
    private MarketData marketData;

    @JsonProperty("community_data")
    private CommunityData communityData;

    @JsonProperty("developer_data")
    private DeveloperData developerData;

    @JsonProperty("status_updates")
    private List<Object> statusUpdates;

    @JsonProperty("last_updated")
    private String lastUpdated;

    private List<Ticker> tickers;

    public String getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public String getWebSlug() {
        return webSlug;
    }

    public String getAssetPlatformId() {
        return assetPlatformId;
    }

    public Map<String, String> getPlatforms() {
        return platforms;
    }

    public Map<String, DetailPlatform> getDetailPlatforms() {
        return detailPlatforms;
    }

    public Integer getBlockTimeInMinutes() {
        return blockTimeInMinutes;
    }

    public String getHashingAlgorithm() {
        return hashingAlgorithm;
    }

    public List<String> getCategories() {
        return categories;
    }

    public Boolean getPreviewListing() {
        return previewListing;
    }

    public String getPublicNotice() {
        return publicNotice;
    }

    public List<String> getAdditionalNotices() {
        return additionalNotices;
    }

    public Map<String, String> getLocalization() {
        return localization;
    }

    public Map<String, String> getDescription() {
        return description;
    }

    public Links getLinks() {
        return links;
    }

    public Image getImage() {
        return image;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public String getGenesisDate() {
        return genesisDate;
    }

    public BigDecimal getSentimentVotesUpPercentage() {
        return sentimentVotesUpPercentage;
    }

    public BigDecimal getSentimentVotesDownPercentage() {
        return sentimentVotesDownPercentage;
    }

    public Long getWatchlistPortfolioUsers() {
        return watchlistPortfolioUsers;
    }

    public Integer getMarketCapRank() {
        return marketCapRank;
    }

    public MarketData getMarketData() {
        return marketData;
    }

    public CommunityData getCommunityData() {
        return communityData;
    }

    public DeveloperData getDeveloperData() {
        return developerData;
    }

    public List<Object> getStatusUpdates() {
        return statusUpdates;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public List<Ticker> getTickers() {
        return tickers;
    }

    public static class DetailPlatform {
        @JsonProperty("decimal_place")
        private Integer decimalPlace;

        @JsonProperty("contract_address")
        private String contractAddress;

        public Integer getDecimalPlace() {
            return decimalPlace;
        }

        public String getContractAddress() {
            return contractAddress;
        }
    }

    public static class Links {
        private List<String> homepage;
        private String whitepaper;

        @JsonProperty("blockchain_site")
        private List<String> blockchainSite;

        @JsonProperty("official_forum_url")
        private List<String> officialForumUrl;

        @JsonProperty("chat_url")
        private List<String> chatUrl;

        @JsonProperty("announcement_url")
        private List<String> announcementUrl;

        @JsonProperty("snapshot_url")
        private String snapshotUrl;

        @JsonProperty("twitter_screen_name")
        private String twitterScreenName;

        @JsonProperty("facebook_username")
        private String facebookUsername;

        @JsonProperty("bitcointalk_thread_identifier")
        private String bitcointalkThreadIdentifier;

        @JsonProperty("telegram_channel_identifier")
        private String telegramChannelIdentifier;

        @JsonProperty("subreddit_url")
        private String subredditUrl;

        @JsonProperty("repos_url")
        private ReposUrl reposUrl;

        public List<String> getHomepage() {
            return homepage;
        }

        public String getWhitepaper() {
            return whitepaper;
        }

        public List<String> getBlockchainSite() {
            return blockchainSite;
        }

        public List<String> getOfficialForumUrl() {
            return officialForumUrl;
        }

        public List<String> getChatUrl() {
            return chatUrl;
        }

        public List<String> getAnnouncementUrl() {
            return announcementUrl;
        }

        public String getSnapshotUrl() {
            return snapshotUrl;
        }

        public String getTwitterScreenName() {
            return twitterScreenName;
        }

        public String getFacebookUsername() {
            return facebookUsername;
        }

        public String getBitcointalkThreadIdentifier() {
            return bitcointalkThreadIdentifier;
        }

        public String getTelegramChannelIdentifier() {
            return telegramChannelIdentifier;
        }

        public String getSubredditUrl() {
            return subredditUrl;
        }

        public ReposUrl getReposUrl() {
            return reposUrl;
        }
    }

    public static class ReposUrl {
        private List<String> github;
        private List<String> bitbucket;

        public List<String> getGithub() {
            return github;
        }

        public List<String> getBitbucket() {
            return bitbucket;
        }
    }

    public static class Image {
        private String thumb;
        private String small;
        private String large;

        public String getThumb() {
            return thumb;
        }

        public String getSmall() {
            return small;
        }

        public String getLarge() {
            return large;
        }
    }

    public static class MarketData {
        @JsonProperty("current_price")
        private Map<String, BigDecimal> currentPrice;

        @JsonProperty("total_value_locked")
        private Object totalValueLocked;

        @JsonProperty("mcap_to_tvl_ratio")
        private Object mcapToTvlRatio;

        @JsonProperty("fdv_to_tvl_ratio")
        private Object fdvToTvlRatio;

        private Object roi;

        private Ath ath;

        @JsonProperty("ath_change_percentage")
        private Map<String, BigDecimal> athChangePercentage;

        @JsonProperty("ath_date")
        private Map<String, String> athDate;

        private Atl atl;

        @JsonProperty("atl_change_percentage")
        private Map<String, BigDecimal> atlChangePercentage;

        @JsonProperty("atl_date")
        private Map<String, String> atlDate;

        @JsonProperty("market_cap")
        private Map<String, BigDecimal> marketCap;

        @JsonProperty("market_cap_rank")
        private Integer marketCapRank;

        @JsonProperty("fully_diluted_valuation")
        private Map<String, BigDecimal> fullyDilutedValuation;

        @JsonProperty("market_cap_fdv_ratio")
        private BigDecimal marketCapFdvRatio;

        @JsonProperty("total_volume")
        private Map<String, BigDecimal> totalVolume;

        @JsonProperty("high_24h")
        private Map<String, BigDecimal> high24h;

        @JsonProperty("low_24h")
        private Map<String, BigDecimal> low24h;

        @JsonProperty("price_change_24h")
        private BigDecimal priceChange24h;

        @JsonProperty("price_change_percentage_24h")
        private BigDecimal priceChangePercentage24h;

        @JsonProperty("price_change_percentage_7d")
        private BigDecimal priceChangePercentage7d;

        @JsonProperty("price_change_percentage_14d")
        private BigDecimal priceChangePercentage14d;

        @JsonProperty("price_change_percentage_30d")
        private BigDecimal priceChangePercentage30d;

        @JsonProperty("price_change_percentage_60d")
        private BigDecimal priceChangePercentage60d;

        @JsonProperty("price_change_percentage_200d")
        private BigDecimal priceChangePercentage200d;

        @JsonProperty("price_change_percentage_1y")
        private BigDecimal priceChangePercentage1y;

        @JsonProperty("market_cap_change_24h")
        private BigDecimal marketCapChange24h;

        @JsonProperty("market_cap_change_percentage_24h")
        private BigDecimal marketCapChangePercentage24h;

        @JsonProperty("price_change_24h_in_currency")
        private Map<String, BigDecimal> priceChange24hInCurrency;

        @JsonProperty("price_change_percentage_1h_in_currency")
        private Map<String, BigDecimal> priceChangePercentage1hInCurrency;

        @JsonProperty("price_change_percentage_24h_in_currency")
        private Map<String, BigDecimal> priceChangePercentage24hInCurrency;

        @JsonProperty("price_change_percentage_7d_in_currency")
        private Map<String, BigDecimal> priceChangePercentage7dInCurrency;

        @JsonProperty("price_change_percentage_14d_in_currency")
        private Map<String, BigDecimal> priceChangePercentage14dInCurrency;

        @JsonProperty("price_change_percentage_30d_in_currency")
        private Map<String, BigDecimal> priceChangePercentage30dInCurrency;

        @JsonProperty("price_change_percentage_60d_in_currency")
        private Map<String, BigDecimal> priceChangePercentage60dInCurrency;

        @JsonProperty("price_change_percentage_200d_in_currency")
        private Map<String, BigDecimal> priceChangePercentage200dInCurrency;

        @JsonProperty("price_change_percentage_1y_in_currency")
        private Map<String, BigDecimal> priceChangePercentage1yInCurrency;

        @JsonProperty("market_cap_change_24h_in_currency")
        private Map<String, BigDecimal> marketCapChange24hInCurrency;

        @JsonProperty("market_cap_change_percentage_24h_in_currency")
        private Map<String, BigDecimal> marketCapChangePercentage24hInCurrency;

        @JsonProperty("total_supply")
        private BigDecimal totalSupply;

        @JsonProperty("max_supply")
        private BigDecimal maxSupply;

        @JsonProperty("max_supply_infinite")
        private Boolean maxSupplyInfinite;

        @JsonProperty("circulating_supply")
        private BigDecimal circulatingSupply;

        @JsonProperty("last_updated")
        private String lastUpdated;

        public Map<String, BigDecimal> getCurrentPrice() {
            return currentPrice;
        }

        public Object getTotalValueLocked() {
            return totalValueLocked;
        }

        public Object getMcapToTvlRatio() {
            return mcapToTvlRatio;
        }

        public Object getFdvToTvlRatio() {
            return fdvToTvlRatio;
        }

        public Object getRoi() {
            return roi;
        }

        public Ath getAth() {
            return ath;
        }

        public Map<String, BigDecimal> getAthChangePercentage() {
            return athChangePercentage;
        }

        public Map<String, String> getAthDate() {
            return athDate;
        }

        public Atl getAtl() {
            return atl;
        }

        public Map<String, BigDecimal> getAtlChangePercentage() {
            return atlChangePercentage;
        }

        public Map<String, String> getAtlDate() {
            return atlDate;
        }

        public Map<String, BigDecimal> getMarketCap() {
            return marketCap;
        }

        public Integer getMarketCapRank() {
            return marketCapRank;
        }

        public Map<String, BigDecimal> getFullyDilutedValuation() {
            return fullyDilutedValuation;
        }

        public BigDecimal getMarketCapFdvRatio() {
            return marketCapFdvRatio;
        }

        public Map<String, BigDecimal> getTotalVolume() {
            return totalVolume;
        }

        public Map<String, BigDecimal> getHigh24h() {
            return high24h;
        }

        public Map<String, BigDecimal> getLow24h() {
            return low24h;
        }

        public BigDecimal getPriceChange24h() {
            return priceChange24h;
        }

        public BigDecimal getPriceChangePercentage24h() {
            return priceChangePercentage24h;
        }

        public BigDecimal getPriceChangePercentage7d() {
            return priceChangePercentage7d;
        }

        public BigDecimal getPriceChangePercentage14d() {
            return priceChangePercentage14d;
        }

        public BigDecimal getPriceChangePercentage30d() {
            return priceChangePercentage30d;
        }

        public BigDecimal getPriceChangePercentage60d() {
            return priceChangePercentage60d;
        }

        public BigDecimal getPriceChangePercentage200d() {
            return priceChangePercentage200d;
        }

        public BigDecimal getPriceChangePercentage1y() {
            return priceChangePercentage1y;
        }

        public BigDecimal getMarketCapChange24h() {
            return marketCapChange24h;
        }

        public BigDecimal getMarketCapChangePercentage24h() {
            return marketCapChangePercentage24h;
        }

        public Map<String, BigDecimal> getPriceChange24hInCurrency() {
            return priceChange24hInCurrency;
        }

        public Map<String, BigDecimal> getPriceChangePercentage1hInCurrency() {
            return priceChangePercentage1hInCurrency;
        }

        public Map<String, BigDecimal> getPriceChangePercentage24hInCurrency() {
            return priceChangePercentage24hInCurrency;
        }

        public Map<String, BigDecimal> getPriceChangePercentage7dInCurrency() {
            return priceChangePercentage7dInCurrency;
        }

        public Map<String, BigDecimal> getPriceChangePercentage14dInCurrency() {
            return priceChangePercentage14dInCurrency;
        }

        public Map<String, BigDecimal> getPriceChangePercentage30dInCurrency() {
            return priceChangePercentage30dInCurrency;
        }

        public Map<String, BigDecimal> getPriceChangePercentage60dInCurrency() {
            return priceChangePercentage60dInCurrency;
        }

        public Map<String, BigDecimal> getPriceChangePercentage200dInCurrency() {
            return priceChangePercentage200dInCurrency;
        }

        public Map<String, BigDecimal> getPriceChangePercentage1yInCurrency() {
            return priceChangePercentage1yInCurrency;
        }

        public Map<String, BigDecimal> getMarketCapChange24hInCurrency() {
            return marketCapChange24hInCurrency;
        }

        public Map<String, BigDecimal> getMarketCapChangePercentage24hInCurrency() {
            return marketCapChangePercentage24hInCurrency;
        }

        public BigDecimal getTotalSupply() {
            return totalSupply;
        }

        public BigDecimal getMaxSupply() {
            return maxSupply;
        }

        public Boolean getMaxSupplyInfinite() {
            return maxSupplyInfinite;
        }

        public BigDecimal getCirculatingSupply() {
            return circulatingSupply;
        }

        public String getLastUpdated() {
            return lastUpdated;
        }
    }

    public static class Ath {
        private Map<String, BigDecimal> prices;

        public Map<String, BigDecimal> getPrices() {
            return prices;
        }
    }

    public static class Atl {
        private Map<String, BigDecimal> prices;

        public Map<String, BigDecimal> getPrices() {
            return prices;
        }
    }

    public static class CommunityData {
        @JsonProperty("facebook_likes")
        private Long facebookLikes;

        @JsonProperty("reddit_average_posts_48h")
        private BigDecimal redditAveragePosts48h;

        @JsonProperty("reddit_average_comments_48h")
        private BigDecimal redditAverageComments48h;

        @JsonProperty("reddit_subscribers")
        private Long redditSubscribers;

        @JsonProperty("reddit_accounts_active_48h")
        private Long redditAccountsActive48h;

        @JsonProperty("telegram_channel_user_count")
        private Long telegramChannelUserCount;

        public Long getFacebookLikes() {
            return facebookLikes;
        }

        public BigDecimal getRedditAveragePosts48h() {
            return redditAveragePosts48h;
        }

        public BigDecimal getRedditAverageComments48h() {
            return redditAverageComments48h;
        }

        public Long getRedditSubscribers() {
            return redditSubscribers;
        }

        public Long getRedditAccountsActive48h() {
            return redditAccountsActive48h;
        }

        public Long getTelegramChannelUserCount() {
            return telegramChannelUserCount;
        }
    }

    public static class DeveloperData {
        private Long forks;
        private Long stars;
        private Long subscribers;

        @JsonProperty("total_issues")
        private Long totalIssues;

        @JsonProperty("closed_issues")
        private Long closedIssues;

        @JsonProperty("pull_requests_merged")
        private Long pullRequestsMerged;

        @JsonProperty("pull_request_contributors")
        private Long pullRequestContributors;

        @JsonProperty("code_additions_deletions_4_weeks")
        private CodeChanges codeAdditionsDeletions4Weeks;

        @JsonProperty("commit_count_4_weeks")
        private Long commitCount4Weeks;

        @JsonProperty("last_4_weeks_commit_activity_series")
        private List<Long> last4WeeksCommitActivitySeries;

        public Long getForks() {
            return forks;
        }

        public Long getStars() {
            return stars;
        }

        public Long getSubscribers() {
            return subscribers;
        }

        public Long getTotalIssues() {
            return totalIssues;
        }

        public Long getClosedIssues() {
            return closedIssues;
        }

        public Long getPullRequestsMerged() {
            return pullRequestsMerged;
        }

        public Long getPullRequestContributors() {
            return pullRequestContributors;
        }

        public CodeChanges getCodeAdditionsDeletions4Weeks() {
            return codeAdditionsDeletions4Weeks;
        }

        public Long getCommitCount4Weeks() {
            return commitCount4Weeks;
        }

        public List<Long> getLast4WeeksCommitActivitySeries() {
            return last4WeeksCommitActivitySeries;
        }
    }

    public static class CodeChanges {
        private Long additions;
        private Long deletions;

        public Long getAdditions() {
            return additions;
        }

        public Long getDeletions() {
            return deletions;
        }
    }

    public static class Ticker {
        private String base;
        private String target;
        private Market market;
        private BigDecimal last;
        private BigDecimal volume;

        @JsonProperty("converted_last")
        private ConvertedPrice convertedLast;

        @JsonProperty("converted_volume")
        private ConvertedVolume convertedVolume;

        @JsonProperty("trust_score")
        private String trustScore;

        @JsonProperty("bid_ask_spread_percentage")
        private BigDecimal bidAskSpreadPercentage;

        private String timestamp;

        @JsonProperty("last_traded_at")
        private String lastTradedAt;

        @JsonProperty("last_fetch_at")
        private String lastFetchAt;

        @JsonProperty("is_anomaly")
        private Boolean isAnomaly;

        @JsonProperty("is_stale")
        private Boolean isStale;

        @JsonProperty("trade_url")
        private String tradeUrl;

        @JsonProperty("token_info_url")
        private String tokenInfoUrl;

        @JsonProperty("coin_id")
        private String coinId;

        @JsonProperty("target_coin_id")
        private String targetCoinId;

        @JsonProperty("coin_mcap_usd")
        private BigDecimal coinMcapUsd;

        public String getBase() {
            return base;
        }

        public String getTarget() {
            return target;
        }

        public Market getMarket() {
            return market;
        }

        public BigDecimal getLast() {
            return last;
        }

        public BigDecimal getVolume() {
            return volume;
        }

        public ConvertedPrice getConvertedLast() {
            return convertedLast;
        }

        public ConvertedVolume getConvertedVolume() {
            return convertedVolume;
        }

        public String getTrustScore() {
            return trustScore;
        }

        public BigDecimal getBidAskSpreadPercentage() {
            return bidAskSpreadPercentage;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public String getLastTradedAt() {
            return lastTradedAt;
        }

        public String getLastFetchAt() {
            return lastFetchAt;
        }

        public Boolean getAnomaly() {
            return isAnomaly;
        }

        public Boolean getStale() {
            return isStale;
        }

        public String getTradeUrl() {
            return tradeUrl;
        }

        public String getTokenInfoUrl() {
            return tokenInfoUrl;
        }

        public String getCoinId() {
            return coinId;
        }

        public String getTargetCoinId() {
            return targetCoinId;
        }

        public BigDecimal getCoinMcapUsd() {
            return coinMcapUsd;
        }
    }

    public static class Market {
        private String name;
        private String identifier;

        @JsonProperty("has_trading_incentive")
        private Boolean hasTradingIncentive;

        public String getName() {
            return name;
        }

        public String getIdentifier() {
            return identifier;
        }

        public Boolean getHasTradingIncentive() {
            return hasTradingIncentive;
        }
    }

    public static class ConvertedPrice {
        private BigDecimal btc;
        private BigDecimal eth;
        private BigDecimal usd;

        public BigDecimal getBtc() {
            return btc;
        }

        public BigDecimal getEth() {
            return eth;
        }

        public BigDecimal getUsd() {
            return usd;
        }
    }


    public static class ConvertedVolume {
        private BigDecimal btc;
        private BigDecimal eth;
        private BigDecimal usd;

        public BigDecimal getBtc() {
            return btc;
        }

        public BigDecimal getEth() {
            return eth;
        }

        public BigDecimal getUsd() {
            return usd;
        }
    }
}