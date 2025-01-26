package com.example.hst137.controller.schedule;

import com.example.hst137.dto.schedule.response.ScheduleResponse;
import com.example.hst137.service.schedule.ScheduleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }
/*
    @GetMapping("/schedule")
    public getSchedule(ScheduleResponse response) {

    }
 */
}
