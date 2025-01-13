package com.example.hst137.config;

import com.example.hst137.repository.exercise.ExerciseJdbcRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ExerciseConfiguration {
    @Bean
    public ExerciseJdbcRepository exerciseRepository(JdbcTemplate jdbcTemplate) {
        return new ExerciseJdbcRepository(jdbcTemplate);
    }
}
