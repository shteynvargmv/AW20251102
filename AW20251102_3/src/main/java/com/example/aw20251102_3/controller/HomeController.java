package com.example.aw20251102_3.controller;

import com.example.aw20251102_3.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/news/")
public class HomeController {
    private final String API_KEY = "db20bd357fe44930a3944537a8092ad0";
    Cache cache = new Cache(60 * 1000 * 30);

    //    1. **GET /api/news/search?q={query}&page={page}&pageSize={size}**
    //   - Поиск новостей по ключевым словам
    //   - Пример: localhost:8080/api/news/search?q=bitcoin&page=1&pageSize=10
    @GetMapping("/search")
    public ResponseEntity<?> search(
            @RequestParam(name = "q") String query,
            @RequestParam Integer page,
            @RequestParam Integer pageSize
    ) {

        query = query.toLowerCase();

        if (page == null || page <= 0) {
            HashMap<String, String> result = new HashMap<>();
            result.put("result", "Ошибка ввода: page <= 0");
            return ResponseEntity.badRequest().body(result);
        }
        if (pageSize == null || pageSize <= 0) {
            HashMap<String, String> result = new HashMap<>();
            result.put("result", "Ошибка ввода: pageSize <= 0");
            return ResponseEntity.badRequest().body(result);
        }

        Map<String, String> params = new HashMap<>();
        params.put("q", query);
        params.put("page", Integer.toString(page));
        params.put("pageSize", Integer.toString(pageSize));
        CacheKey cacheKey = new CacheKey("/search", params);
        NewsApiResponse cached = (NewsApiResponse) cache.get(cacheKey);
        if (cached != null) {
            System.out.println("Запрос из кэша : " + cacheKey);
            return ResponseEntity.ok(cached);
        }

        System.out.println("Запрос из API : " + cacheKey);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<NewsApiResponse> response;

        String url = "https://newsapi.org/v2/everything?q=" +
                query + "&page=" + page + "&pageSize=" + pageSize + "&apiKey=" + API_KEY;

        response = restTemplate.getForEntity(url, NewsApiResponse.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            NewsApiResponse result = response.getBody();
            cache.put(cacheKey, result);
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new HashMap<String, String>() {{
                    put("result", "Not Found");
                }});
    }

    //   2. **GET /api/news/top?country={country}&category={category}**
    //   - Топ новости страны
    //   - Пример: localhost:8080/api/news/top?country=us&category=technology
    @GetMapping("/top")
    public ResponseEntity<?> top(
            @RequestParam String country,
            @RequestParam String category
    ) {

        country = country.toLowerCase();
        category = category.toLowerCase();

        Map<String, String> params = new HashMap<>();
        params.put("country", country);
        params.put("category", category);
        CacheKey cacheKey = new CacheKey("/top", params);
        NewsApiResponse cached = (NewsApiResponse) cache.get(cacheKey);
        if (cached != null) {
            System.out.println("Запрос из кэша : " + cacheKey);
            return ResponseEntity.ok(cached);
        }

        System.out.println("Запрос из API : " + cacheKey);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<NewsApiResponse> response;

        String url = "https://newsapi.org/v2/top-headlines?country=" +
                country + "&category=" + category + "&apiKey=" + API_KEY;

        response = restTemplate.getForEntity(url, NewsApiResponse.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            NewsApiResponse result = response.getBody();
            cache.put(cacheKey, result);
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new HashMap<String, String>() {{
                    put("result", "Not Found");
                }});
    }

    //   3. **GET /api/news/sources?category={category}&country={country}**
    //   - Получить список источников новостей
    //   - Пример: localhost:8080/api/news/by-source?source=bbc-news&page=1
    @GetMapping("/sources")
    public ResponseEntity<?> sources(
            @RequestParam String country,
            @RequestParam String category
    ) {

        country = country.toLowerCase();
        category = category.toLowerCase();

        Map<String, String> params = new HashMap<>();
        params.put("country", country);
        params.put("category", category);
        CacheKey cacheKey = new CacheKey("/sources", params);
        SourcesResponse cached = (SourcesResponse) cache.get(cacheKey);
        if (cached != null) {
            System.out.println("Запрос из кэша : " + cacheKey);
            return ResponseEntity.ok(cached);
        }

        System.out.println("Запрос из API : " + cacheKey);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SourcesResponse> response;

        String url = "https://newsapi.org/v2/top-headlines/sources?category="
                + category + "&country=" + country + "&apiKey=" + API_KEY;

        response = restTemplate.getForEntity(url, SourcesResponse.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            SourcesResponse result = response.getBody();
            cache.put(cacheKey, result);
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new HashMap<String, String>() {{
                    put("result", "Not Found");
                }});
    }

    //    4. **GET /api/news/by-source?source={sourceId}&page={page}**
    //   - Новости от конкретного источника
    //   - Пример: `/api/news/by-source?source=bbc-news&page=1`
    @GetMapping("/by-source")
    public ResponseEntity<?> bySource(
            @RequestParam(name = "source") String sourceId,
            @RequestParam Integer page
    ) {

        sourceId = sourceId.toLowerCase();
        if (page == null || page <= 0) {
            HashMap<String, String> result = new HashMap<>();
            result.put("result", "Ошибка ввода: page <= 0");
            return ResponseEntity.badRequest().body(result);
        }

        Map<String, String> params = new HashMap<>();
        params.put("sourceId", sourceId);
        params.put("page", Integer.toString(page));
        CacheKey cacheKey = new CacheKey("/by-source", params);
        NewsApiResponse cached = (NewsApiResponse) cache.get(cacheKey);
        if (cached != null) {
            System.out.println("Запрос из кэша : " + cacheKey);
            return ResponseEntity.ok(cached);
        }

        System.out.println("Запрос из API : " + cacheKey);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<NewsApiResponse> response;

        String url = "https://newsapi.org/v2/top-headlines?sources=" +
                sourceId + "&page=" + page + "&apiKey=" + API_KEY;

        response = restTemplate.getForEntity(url, NewsApiResponse.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            NewsApiResponse result = response.getBody();
            cache.put(cacheKey, result);
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new HashMap<String, String>() {{
                    put("result", "Not Found");
                }});
    }


    //  localhost:8080/api/news/cache/stats
    @GetMapping("/cache/stats")
    public ResponseEntity<?> cacheStats() {
        CacheStat cacheStat = new CacheStat(cache);
        if (!cacheStat.getCacheEntries().isEmpty()) {
            return ResponseEntity.ok(cacheStat);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new HashMap<String, String>() {{
                        put("result", "Кэш пуст");
                    }});
        }
    }

    //  localhost:8080/api/crypto/cache/clear
    @PostMapping("/cache/clear")
    public ResponseEntity<HashMap<String, String>> cacheClear() {
        cache.clear();
        HashMap<String, String> result = new HashMap<>();
        if (cache.isEmpty()) {
            result.put("result", "Кэш успешно очищен");
        } else {
            result.put("result", "Очистить кэш не удалось");
        }
        return ResponseEntity.ok(result);
    }

}
