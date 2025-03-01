package org.example;

import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/cache")
public class CacheController {
    private final Map<String, String> cache = new ConcurrentHashMap<>();

    @PostMapping("/update")
    public String updateCache(@RequestBody CacheUpdate update) {
        cache.put(update.getKey(), update.getValue());
        return String.format("Cache updated on pod %s: {%s: %s}",
                System.getenv("HOSTNAME"), update.getKey(), update.getValue());
    }

    @GetMapping("/view")
    public Map<String, String> viewCache() {
        return cache;
    }
}
