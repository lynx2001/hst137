package com.example.hst137.controller.schedule;

import com.example.hst137.domain.schedule.ScheduleRepository;
import com.example.hst137.dto.schedule.request.ScheduleCreateRequest;
import com.example.hst137.dto.schedule.response.ScheduleResponse;
import com.example.hst137.service.schedule.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScheduleController {
    private final ScheduleService scheduleService;
    private final ScheduleRepository scheduleRepository;

    public ScheduleController(ScheduleService scheduleService, ScheduleRepository scheduleRepository) {
        this.scheduleService = scheduleService;
        this.scheduleRepository = scheduleRepository;
    }

    @PostMapping("/schedule")
    public ResponseEntity<Void> saveSchedule(@RequestBody ScheduleCreateRequest request) {
        scheduleService.saveSchedule(request);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/schedule")
    public List<ScheduleResponse> getSchedules() {
        return scheduleService.getSchedules();
    }

    @GetMapping("/schedule/{id}")
    public ScheduleResponse getSchedule(@PathVariable Long id) {
        return scheduleService.getScheduleById(id);
    }

    @GetMapping(value = "/schedule", params = "week")
    public List<ScheduleResponse> getScheduleByWeek(@RequestParam int week) {
        return scheduleService.getScheduleByWeek(week);
    }
}
