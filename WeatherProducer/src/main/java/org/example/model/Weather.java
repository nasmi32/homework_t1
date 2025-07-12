package org.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Random;

@Data
public class Weather {

    private City city;
    private int temp;
    private Condition condition;
    private LocalDate date;

    public Weather(City city, int temp, Condition condition, LocalDate date) {
        this.city = city;
        this.temp = temp;
        this.condition = condition;
        this.date = date;
    }

    public static Weather generateRandomWeather() {
        Random random = new Random();
        int cityIndex = random.nextInt(City.values().length);
        City city = City.values()[cityIndex];

        int temp = random.nextInt(10, 35);

        int conditionIndex = random.nextInt(Condition.values().length);
        Condition condition = Condition.values()[conditionIndex];

        LocalDate date = LocalDate.now().minusDays(random.nextInt(7));

        return new Weather(city, temp, condition, date);
    }

}

