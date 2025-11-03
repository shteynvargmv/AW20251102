package com.example.aw20251102_2.controller;

import com.example.aw20251102_2.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/crypto/")
public class HomeController {
//    private String apiKey = "CG-JfhqEEZsSebGnnbi3Poidrwc";

    Cache cache = new Cache(60 * 1000 * 30);

    //   ** GET /api/crypto/price?ids={bitcoin,cardano}**
    //   - Получить текущие цены криптовалют
    //   - Можно несколько через запятую
    //   - Пример: localhost:8080/api/crypto/price?ids=cardano,bitcoin
    @GetMapping("/price")
    public ResponseEntity<CoinPriceApiResponse> price(
            @RequestParam String ids
    ) {

        ids = ids.toLowerCase();
        Map<String,String> params = new HashMap<>();
        String[] idsList = Arrays.stream(ids.split(",")).sorted().toArray(String[]::new);
        params.put("ids", Arrays.toString(idsList));
        CacheKey cacheKey = new CacheKey("/price", params);
        CoinPriceApiResponse cached = new CoinPriceApiResponse();
        cached = (CoinPriceApiResponse) cache.get(cacheKey);
        if (cached != null) {
            System.out.println("Запрос из кэша : " + cacheKey);
            return ResponseEntity.ok(cached);
        }

        CoinPriceApiResponse result = new CoinPriceApiResponse();
        System.out.println("Запрос из API : " + cacheKey);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CoinApiResponse> response;

        for (String id : idsList) {
            String url = "https://api.coingecko.com/api/v3/coins/" + id;
            response = restTemplate.getForEntity(url, CoinApiResponse.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                CoinApiResponse coin = response.getBody();
                if (coin != null) {
                    result.add(id, coin.getSymbol(), coin.getName(), coin.getMarketData().getCurrentPrice());
                }
            }
        }

        ArrayList<CoinPriceApi> prices = result.getCoinPriceApis();
        if (prices != null && !prices.isEmpty()) {
            cache.put(cacheKey, result);
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    // 2. **GET /api/crypto/top?limit={limit}**
    //   - Топ криптовалют по рыночной капитализации
    //   - Пример: localhost:8080/api/crypto/top?limit=10
    @GetMapping("/top")
    public ResponseEntity<?> top(
            @RequestParam Integer limit
    ) {

        if (limit <= 0) {
            HashMap<String, String> result = new HashMap<>();
            result.put("result", "Ошибка ввода: limit <= 0");
            return ResponseEntity.badRequest().body(result);
        }

        Map<String,String> params = new HashMap<>();
        params.put("limit", Integer.toString(limit) );
        CacheKey cacheKey = new CacheKey("/top", params);
        TopCoinApiResponse[] cached = (TopCoinApiResponse[]) cache.get(cacheKey);
        if (cached != null) {
            System.out.println("Запрос из кэша : " + cacheKey);
            return ResponseEntity.ok(cached);
        }

        System.out.println("Запрос из API : " + cacheKey);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TopCoinApiResponse[]> response;

        String url = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=" +
                limit + "&page=1";

        response = restTemplate.getForEntity(url, TopCoinApiResponse[].class);
        if (response.getStatusCode().is2xxSuccessful()) {
            TopCoinApiResponse[] result = response.getBody();
            cache.put(cacheKey, result);
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new HashMap<String, String>() {{
                    put("result", "Not Found");
                }});
    }

    //   3. **GET /api/crypto/search?query={name}**
    //   - Поиск криптовалюты по названию
    //   - Пример: localhost:8080/api/crypto/search?query=bitcoin
    @GetMapping("/search")
    public ResponseEntity<?> search(
            @RequestParam String query
    ) {

        query = query.toLowerCase();
        Map<String,String> params = new HashMap<>();
        params.put("query", query );
        CacheKey cacheKey = new CacheKey("/search", params);
        CoinApiResponse cached = (CoinApiResponse) cache.get(cacheKey);
        if (cached != null) {
            System.out.println("Запрос из кэша : " + cacheKey);
            return ResponseEntity.ok(cached);
        }

        System.out.println("Запрос из API : " + cacheKey);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CoinApiResponse> response;

        String url = "https://api.coingecko.com/api/v3/coins/" + query;

        response = restTemplate.getForEntity(url, CoinApiResponse.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            CoinApiResponse result = response.getBody();
            cache.put(cacheKey, result);
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new HashMap<String, String>() {{
                    put("result", "Not Found");
                }});
    }

    //  4. **GET /api/crypto/compare?ids={bitcoin,ethereum}**
    //   - Сравнить несколько криптовалют
    //   - Показать разницу в ценах и изменениях
    //   - Какая дороже
    //   - Какая больше выросла/упала за 24ч MarketData.priceChange24h (беру по модулю)
    //   - Какая больше по капитализации MarketData.marketCap
    //   - Пример: localhost:8080/api/crypto/compare?ids=cardano,bitcoin
    @GetMapping("/compare")
    public ResponseEntity<?> compare(
            @RequestParam String ids
    ) {
        ids = ids.toLowerCase();
        String[] idsList = Arrays.stream(ids.split(",")).sorted().toArray(String[]::new);

        if (idsList.length != 2) {
            HashMap<String, String> result = new HashMap<>();
            result.put("result", "Ошибка: Сравнивать можно только 2 криптовалюты");
            return ResponseEntity.badRequest().body(result);
        }

        Map<String,String> params = new HashMap<>();
        params.put("ids", Arrays.toString(idsList));
        CacheKey cacheKey = new CacheKey("/compare", params);
        CryptoCompareResponse cached = (CryptoCompareResponse) cache.get(cacheKey);
        if (cached != null) {
            System.out.println("Запрос из кэша : " + cacheKey);
            return ResponseEntity.ok(cached);
        }

        System.out.println("Запрос из API : " + cacheKey);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CoinApiResponse> response;

        CryptoCompareResponse result = new CryptoCompareResponse();
        for (String id : idsList) {
            String url = "https://api.coingecko.com/api/v3/coins/" + id;
            response = restTemplate.getForEntity(url, CoinApiResponse.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                CoinApiResponse coin = response.getBody();
                if (coin != null) {
                    result.add(coin);
                }
            }
        }

        if (!result.getCryptos().isEmpty()) {
            cache.put(cacheKey, result);
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    //  localhost:8080/api/crypto/cache/stats
    @GetMapping("/cache/stats")
    public ResponseEntity<?> cacheStats() {
        CacheStat cacheStat = new CacheStat(cache);
        if (!cacheStat.getCacheEntries().isEmpty()) {
            return ResponseEntity.ok(cacheStat);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new HashMap<String,String>(){{put("result","Кэш пуст");}});
        }
    }

    //  localhost:8080/api/crypto/cache/clear
    @PostMapping("/cache/clear")
    public ResponseEntity<HashMap<String, String>> cacheClear() {
        cache.clear();
        HashMap<String,String> result = new HashMap<>();
        if (cache.isEmpty()) {
            result.put("result", "Кэш успешно очищен");
        } else {
            result.put("result", "Очистить кэш не удалось");
        }
        return ResponseEntity.ok(result) ;
    }

}
