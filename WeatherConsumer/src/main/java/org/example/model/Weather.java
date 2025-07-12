package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Random;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private City city;
    private int temp;
    private Condition condition;
    private LocalDate date;

//    public Weather(City city, int temp, Condition condition, LocalDate date) {
//        this.city = city;
//        this.temp = temp;
//        this.condition = condition;
//        this.date = date;
//    }

}
