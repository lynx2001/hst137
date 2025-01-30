package com.example.hst137.dto.schedule.request;

import com.example.hst137.domain.exercise.Exercise;
import lombok.Getter;

@Getter
public class ScheduleUpdateRequest {
    private Exercise exercise;
}
