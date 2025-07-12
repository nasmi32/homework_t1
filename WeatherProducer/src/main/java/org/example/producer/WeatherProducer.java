package org.example.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.model.Weather;
import org.example.model.WeatherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WeatherProducer {
    @Value("${topic.name}")
    private String topicName;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public WeatherProducer(ObjectMapper objectMapper, KafkaTemplate<String, String> kafkaTemplate) {
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 2000)
    public String sendMessage() throws JsonProcessingException {
        Weather weather = Weather.generateRandomWeather();
        WeatherDto weatherDto = objectMapper.convertValue(weather, WeatherDto.class);

        String weatherAsMessage = objectMapper.writeValueAsString(weatherDto);
        kafkaTemplate.send(topicName, weatherAsMessage);

        log.info("Weather added: {}", weatherAsMessage);

        return "Message sent";
    }

    public String sendMessageByHand(Weather weather) throws JsonProcessingException {
        WeatherDto weatherDto = objectMapper.convertValue(weather, WeatherDto.class);

        String weatherAsMessage = objectMapper.writeValueAsString(weatherDto);
        kafkaTemplate.send(topicName, weatherAsMessage);

        log.info("Weather added by hand: {}", weatherAsMessage);

        return "Message sent";
    }
}
