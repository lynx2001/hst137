package com.example.hst137.dto.schedule.response;

import com.example.hst137.domain.exercise.Exercise;
import com.example.hst137.domain.schedule.Schedule;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class ScheduleResponse {
    private Long id;
    private List<Exercise> exercises;
    private LocalDate date;
    private int week;

    public ScheduleResponse(Long id, List<Exercise> exercises, LocalDate date, int week) {
        this.id = id;
        this.exercises = exercises;
        this.date = date;
        this.week = week;
    }

    public ScheduleResponse(Schedule schedule) {
        this.id = schedule.getId();
        this.date = schedule.getDate();
        this.week = schedule.getWeek();
        this.exercises = schedule.getExercises();
    }
}
