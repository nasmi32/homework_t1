package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.example.producer.WeatherProducer;
import org.example.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WeatherService {
    private final WeatherProducer weatherProducer;

    @Autowired
    public WeatherService(WeatherProducer weatherProducer) {
        this.weatherProducer = weatherProducer;
    }

    public String addWeather(Weather weather) throws JsonProcessingException {
        return weatherProducer.sendMessageByHand(weather);
    }

}
