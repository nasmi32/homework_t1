package org.example.repository;

import org.example.model.Weather;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
    // Самый жаркий день
    @Query("SELECT w FROM Weather w ORDER BY w.temp DESC LIMIT 1")
    Weather findHottestDay();

    // Средняя температура
    @Query("SELECT AVG(w.temp) FROM Weather w")
    Double findAverageTemperature();

    // Топ N самых жарких дней
    @Query("SELECT w FROM Weather w ORDER BY w.temp DESC")
    List<Weather> findTopNHottestDays(Pageable pageable);
}
