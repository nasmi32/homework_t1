package org.example.controller;

import org.example.model.Weather;
import org.example.service.WeatherStatsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stats")
public class WeatherStatsController {
    private final WeatherStatsService weatherStatsService;

    public WeatherStatsController(WeatherStatsService weatherStatsService) {
        this.weatherStatsService = weatherStatsService;
    }

    @GetMapping("/hottest")
    public ResponseEntity<Weather> hottest() {
        return ResponseEntity.ok(weatherStatsService.getHottestDay());
    }

    @GetMapping("/average")
    public ResponseEntity<Double> getAverageTemp() {
        return ResponseEntity.ok(weatherStatsService.getAverageTemperature());
    }

    @GetMapping("/top")
    public ResponseEntity<List<Weather>> getTopHottestDays(@RequestParam(defaultValue = "5") int count) {
        return ResponseEntity.ok(weatherStatsService.getTopNHottestDays(count));
    }

}
