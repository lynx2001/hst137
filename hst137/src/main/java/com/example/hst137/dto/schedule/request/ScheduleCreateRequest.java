package com.example.hst137.dto.schedule.request;

import com.example.hst137.domain.exercise.Exercise;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class ScheduleCreateRequest {
    private LocalDate date;

    public ScheduleCreateRequest(LocalDate date) {
        this.date = date;
    }
}
