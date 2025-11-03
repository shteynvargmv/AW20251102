package com.example.aw20251102_4.controller;


import com.example.aw20251102_4.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/recipes/")
public class HomeController {
    private final String API_KEY = "68216f7d16ef418cad346ff45ba17251";
    Cache cache = new Cache(60 * 1000 * 30);

    //   1. **GET /api/recipes/search?query={query}&number={number}**
    //   - Поиск рецептов по названию
    //   - Пример: localhost:8080/api/recipes/search?query=pasta&number=10
    @GetMapping("/search")
    public ResponseEntity<?> search(
            @RequestParam String query,
            @RequestParam Integer number
    ) {

        query = query.toLowerCase();
        if (number == null || number <= 0) {
            HashMap<String, String> result = new HashMap<>();
            result.put("result", "Ошибка ввода: number <= 0");
            return ResponseEntity.badRequest().body(result);
        }

        Map<String, String> params = new HashMap<>();
        params.put("query", query);
        params.put("number", Integer.toString(number));
        CacheKey cacheKey = new CacheKey("/search", params);
        RecipesResponse cached = (RecipesResponse) cache.get(cacheKey);
        if (cached != null) {
            System.out.println("Запрос из кэша : " + cacheKey);
            return ResponseEntity.ok(cached);
        }

        System.out.println("Запрос из API : " + cacheKey);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RecipesResponse> response;

        String url = "https://api.spoonacular.com/recipes/complexSearch?query=" +
                query + "&number=" + number + "&apiKey=" + API_KEY;

        response = restTemplate.getForEntity(url, RecipesResponse.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            RecipesResponse result = response.getBody();
            cache.put(cacheKey, result);
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new HashMap<String, String>() {{
                    put("result", "Not Found");
                }});
    }

    //   2. **GET /api/recipes/by-ingredients?ingredients={ingredients}&number={number}**
    //   - Поиск по ингредиентам
    //   - Пример: localhost:8080/api/recipes/by-ingredients?ingredients=chicken,rice&number=5
    @GetMapping("/by-ingredients")
    public ResponseEntity<?> byIngredients(
            @RequestParam String ingredients,
            @RequestParam Integer number
    ) {

        ingredients = ingredients.toLowerCase();
        if (number == null || number <= 0) {
            HashMap<String, String> result = new HashMap<>();
            result.put("result", "Ошибка ввода: number <= 0");
            return ResponseEntity.badRequest().body(result);
        }

        Map<String, String> params = new HashMap<>();
        String[] ingredientsList = Arrays.stream(ingredients.split(",")).sorted().toArray(String[]::new);
        params.put("ingredients", Arrays.toString(ingredientsList));
        CacheKey cacheKey = new CacheKey("/byIngredients", params);
        RecipeMatchResponse[] cached = (RecipeMatchResponse[]) cache.get(cacheKey);
        if (cached != null) {
            System.out.println("Запрос из кэша : " + cacheKey);
            return ResponseEntity.ok(cached);
        }

        System.out.println("Запрос из API : " + cacheKey);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RecipeMatchResponse[]> response;

        String url = "https://api.spoonacular.com/recipes/findByIngredients?ingredients=" +
                ingredients + "&number=" + number + "&apiKey=" + API_KEY;

        response = restTemplate.getForEntity(url, RecipeMatchResponse[].class);
        if (response.getStatusCode().is2xxSuccessful()) {
            RecipeMatchResponse[] result = response.getBody();
            cache.put(cacheKey, result);
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new HashMap<String, String>() {{
                    put("result", "Not Found");
                }});
    }

    //   3. **GET /api/recipes/{id}**
    //   - Получить детальную информацию о рецепте
    //   - Пример: localhost:8080/api/recipes/715538
    @GetMapping("/{id}")
    public ResponseEntity<?> byId(
            @PathVariable String id
    ) {
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        CacheKey cacheKey = new CacheKey("/" + id, params);
        RecipeInfoResponse cached = (RecipeInfoResponse) cache.get(cacheKey);
        if (cached != null) {
            System.out.println("Запрос из кэша : " + cacheKey);
            return ResponseEntity.ok(cached);
        }

        System.out.println("Запрос из API : " + cacheKey);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RecipeInfoResponse> response;

        String url = "https://api.spoonacular.com/recipes/" +
                id + "/information?apiKey=" + API_KEY;

        response = restTemplate.getForEntity(url, RecipeInfoResponse.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            RecipeInfoResponse result = response.getBody();
            cache.put(cacheKey, result);
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new HashMap<String, String>() {{
                    put("result", "Not Found");
                }});
    }

    //   4. **GET /api/recipes/random?number={number}&tags={tags}**
    //   - Случайные рецепты с тегами
    //   - Пример: localhost:8080/api/recipes/random?number=3&tags=vegetarian,dessert
    @GetMapping("/random")
    public ResponseEntity<?> random(
            @RequestParam Integer number,
            @RequestParam String tags
    ) {

        tags = tags.toLowerCase();
        if (number == null || number <= 0) {
            HashMap<String, String> result = new HashMap<>();
            result.put("result", "Ошибка ввода: number <= 0");
            return ResponseEntity.badRequest().body(result);
        }

        Map<String, String> params = new HashMap<>();
        params.put("number", Integer.toString(number));
        String[] tagsList = Arrays.stream(tags.split(",")).sorted().toArray(String[]::new);
        params.put("tags", Arrays.toString(tagsList));
        CacheKey cacheKey = new CacheKey("/random", params);
        RecipesRandResponse cached = (RecipesRandResponse) cache.get(cacheKey);
        if (cached != null) {
            System.out.println("Запрос из кэша : " + cacheKey);
            return ResponseEntity.ok(cached);
        }

        System.out.println("Запрос из API : " + cacheKey);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RecipesRandResponse> response;

        String url = "https://api.spoonacular.com/recipes/random?number=" +
                number + "&tags=" + tags + "&apiKey=" + API_KEY;

        response = restTemplate.getForEntity(url, RecipesRandResponse.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            RecipesRandResponse result = response.getBody();
            cache.put(cacheKey, result);
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new HashMap<String, String>() {{
                    put("result", "Not Found");
                }});
    }

    //  5. **GET /api/recipes/cache/stats**
    //  - Статистика кеша
    //  - Пример: localhost:8080/api/recipes/cache/stats
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

    //  6. **POST /api/recipes/cache/clear**
    //  - Очистить кеш
    //  - Пример: localhost:8080/api/recipes/cache/clear
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
