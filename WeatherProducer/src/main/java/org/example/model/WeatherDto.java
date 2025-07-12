package org.example.model;

import lombok.Value;

import java.time.LocalDate;

@Value
public class WeatherDto {
    City city;
    int temp;
    Condition condition;
    LocalDate date;
}
