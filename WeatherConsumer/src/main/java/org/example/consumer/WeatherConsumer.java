package org.example.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.model.WeatherDto;
import org.example.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WeatherConsumer {

    private static final String topicName = "${topic.name}";

    private final WeatherService weatherService;
    private final ObjectMapper objectMapper;

    @Autowired
    public WeatherConsumer(ObjectMapper objectMapper, WeatherService weatherService) {
        this.objectMapper = objectMapper;
        this.weatherService = weatherService;
    }

    @KafkaListener(topics = topicName)
    public void consumeMessage(String message) throws JsonProcessingException {
        log.info("message consumed {}", message);

        WeatherDto weatherDto = objectMapper.readValue(message, WeatherDto.class);
        weatherService.persistWeather(weatherDto);
    }

}
