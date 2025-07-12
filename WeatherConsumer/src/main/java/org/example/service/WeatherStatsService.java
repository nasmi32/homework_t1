package org.example.service;

import org.example.model.Weather;
import org.example.repository.WeatherRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WeatherStatsService {
    private final WeatherRepository weatherRepository;

    public WeatherStatsService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public Weather getHottestDay() {
        return weatherRepository.findHottestDay();
    }

    public double getAverageTemperature() {
        Double avg = weatherRepository.findAverageTemperature();
        return avg != null ? avg : 0.0;
    }

    public List<Weather> getTopNHottestDays(int count) {
        return weatherRepository.findTopNHottestDays(PageRequest.of(0, count));
    }

}
