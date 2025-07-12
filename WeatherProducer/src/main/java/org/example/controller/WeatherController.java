package org.example.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.example.model.Weather;
import org.example.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService){
        this.weatherService = weatherService;
    }

    @PostMapping
    public String addWeather(@RequestBody Weather weather) throws JsonProcessingException {
        log.info("create weather request received");
        return weatherService.addWeather(weather);
    }

}
