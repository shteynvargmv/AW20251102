package com.example.aw20251102_1.controller;

import com.example.aw20251102_1.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/countries")
public class HomeController {

    Map<String, String> cacheData = new HashMap<>();
    Cache cache = new Cache(60 * 1000 * 30);

    //  localhost:8080/api/countries/search?name=russia
    //  Поиск по имени:
    //  https://restcountries.com/v3.1/name/{name}
    @GetMapping("/search")
    public ResponseEntity<CountryApiResponse[]> search(
            @RequestParam(name = "name") String countryName
    ) {

        CountryApiResponse[] cached = cache.get(new CacheKey("country_name_" + countryName));
        if (cached != null) {
            System.out.println("Запрос из кэша : " + countryName);
            return ResponseEntity.ok(cached);
        }
        System.out.println("Запрос из API : " + countryName);
        RestTemplate restTemplate = new RestTemplate();
        CountryApiResponse[] result;
        ResponseEntity<CountryApiResponse[]> response;

        countryName = countryName.toLowerCase();
        String url = "https://restcountries.com/v3.1/name/" + countryName;
        response = restTemplate.getForEntity(url, CountryApiResponse[].class);

        if (response.getStatusCode().is2xxSuccessful()) {
            result = response.getBody();
            if (result != null && result.length > 0) {
                cache.put(new CacheKey("country_name_" + countryName), response.getBody());
                return ResponseEntity.ok(result);
            }
        }
        return ResponseEntity.notFound().build();
    }

    //  localhost:8080/api/countries/region?name=asia
    //  По региону:
    //  https://restcountries.com/v3.1/region/{region}
    @GetMapping("/region")
    public ResponseEntity<CountryApiResponse[]> region(
            @RequestParam(name = "name") String regionName
    ) {

        CountryApiResponse[] cached = cache.get(new CacheKey("region_name_" + regionName));
        if (cached != null) {
            System.out.println("Запрос из кэша : " + regionName);
            return ResponseEntity.ok(cached);
        }
        System.out.println("Запрос из API : " + regionName);
        RestTemplate restTemplate = new RestTemplate();
        CountryApiResponse[] result;
        ResponseEntity<CountryApiResponse[]> response;

        regionName = regionName.toLowerCase();
        String url = "https://restcountries.com/v3.1/region/" + regionName;
        response = restTemplate.getForEntity(url, CountryApiResponse[].class);

        if (response.getStatusCode().is2xxSuccessful()) {
            result = response.getBody();
            if (result != null && result.length > 0) {
                cache.put(new CacheKey("region_name_" + regionName), response.getBody());
                return ResponseEntity.ok(result);
            }
        }
        return ResponseEntity.notFound().build();
    }

    //  localhost:8080/api/countries/usa/population?min=45&max=500000000
    //  Сервис https://restcountries.com/v3.1/all?fields=population не отрабатывает даже в браузере,
    //  сайт не отвечает, поэтому сделала фильтр для https://restcountries.com/v3.1/name/:
    //  страна будет попадать в результат, только если население в заданных пределах
    //  https://restcountries.com/v3.1/name/{name}/?fields=name,capital,currencies, population
    @GetMapping("/{name}/population")
    public ResponseEntity<?> population(
            @PathVariable(name = "name") String countryName,
            @RequestParam Integer min,
            @RequestParam Integer max
    ) {

        if (min > max) {
            HashMap<String,String> result = new HashMap<>();
            result.put("result", "Ошибка ввода: min > max");
            return ResponseEntity.badRequest().body(result);
        }

        if (min < 0) {
            HashMap<String,String> result = new HashMap<>();
            result.put("result", "Ошибка ввода: min < 0");
            return ResponseEntity.badRequest().body(result);
        }

        if (max < 0) {
            HashMap<String,String> result = new HashMap<>();
            result.put("result", "Ошибка ввода: max < 0");
            return ResponseEntity.badRequest().body(result);
        }

        countryName = countryName.toLowerCase();
        CountryApiResponse[] cached = cache.get(new CacheKey("country_filter_" + countryName, min, max));
        if (cached != null) {
            System.out.println("Запрос из кэша : " + countryName + " население  от " + min + " до " + max);
            return ResponseEntity.ok(cached);
        }

        System.out.println("Запрос из API : " + countryName + " население от " + min + " до " + max);
        RestTemplate restTemplate = new RestTemplate();
        CountryApiResponse[] result;
        ResponseEntity<CountryApiResponse[]> response;

        String url = "https://restcountries.com/v3.1/name/" + countryName +
                "/?fields=name,capital,currencies,population"; //добавила еще фильтр по полям
        response = restTemplate.getForEntity(url, CountryApiResponse[].class);

        if (response.getStatusCode().is2xxSuccessful()) {
            result = response.getBody();
            if (result != null) {
                result = Arrays.stream(result).filter(x -> x.population >= min && x.population <= max)
                        .toArray(CountryApiResponse[]::new);
                if (result.length > 0) {
                    cache.put(new CacheKey("country_filter_" + countryName, min, max), result);
                    return ResponseEntity.ok(result);
                }
            }
        }
        return ResponseEntity.notFound().build();
    }

    //  localhost:8080/api/countries/cache/stats
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

    //  localhost:8080/api/countries/cache/clear
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
