package org.example.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.example.model.Weather;
import org.example.model.WeatherDto;
import org.example.repository.WeatherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WeatherService {
    private final ModelMapper modelMapper;
    private final WeatherRepository weatherRepository;

    @Autowired
    public WeatherService(ModelMapper modelMapper, WeatherRepository weatherRepository) {
        this.modelMapper = modelMapper;
        this.weatherRepository = weatherRepository;
    }

    public void persistWeather (WeatherDto weatherDto) {
        Weather weather = modelMapper.map(weatherDto, Weather.class);
        Weather persistedWeather = weatherRepository.save(weather);

        log.info("food order persisted {}", persistedWeather);
    }
}
