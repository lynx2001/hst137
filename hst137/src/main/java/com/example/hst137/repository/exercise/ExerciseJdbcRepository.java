package com.example.hst137.repository.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ExerciseJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ExerciseJdbcRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
}
