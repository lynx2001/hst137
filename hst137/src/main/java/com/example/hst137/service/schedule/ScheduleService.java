package com.example.hst137.service.schedule;

import com.example.hst137.domain.exercise.Exercise;
import com.example.hst137.domain.exercise.ExerciseRepository;
import com.example.hst137.domain.schedule.Schedule;
import com.example.hst137.domain.schedule.ScheduleRepository;
import com.example.hst137.dto.schedule.request.ScheduleCreateRequest;
import com.example.hst137.dto.schedule.request.ScheduleUpdateRequest;
import com.example.hst137.dto.schedule.response.ScheduleResponse;
import com.example.hst137.service.exercise.ExerciseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final ExerciseRepository exerciseRepository;
    private final ExerciseService exerciseService;

    public ScheduleService(ScheduleRepository scheduleRepository, ExerciseRepository exerciseRepository, ExerciseService exerciseService) {
        this.scheduleRepository = scheduleRepository;
        this.exerciseRepository = exerciseRepository;
        this.exerciseService = exerciseService;
    }

    @Transactional
    public void initializeSchedules(LocalDate startDate) {
        for (int i = 0; i < 32; i++) {
            Schedule schedule = new Schedule(startDate);
            schedule.setDate(startDate.plusDays(2 * i)); // 날짜 계산 (2일 간격)
            schedule.setWeek((i / 4) + 1);               // 주차 계산 (4개의 스케줄마다 1주차 증가)
            scheduleRepository.save(schedule);
        }
    }

    @Transactional
    public void saveSchedule(ScheduleCreateRequest request) {
        List<Exercise> baseExercises = exerciseRepository.findAll(); // 기존 운동 불러오기

        for (int i = 0; i < 32; i++) {
            // 🟢 Schedule 생성 및 저장
            Schedule schedule = new Schedule(request.getDate().plusDays(2 * i));
            schedule.setWeek((i / 4) + 1);
            schedule = scheduleRepository.save(schedule); // 영속 상태로 변경

            for (Exercise baseExercise : baseExercises) {
                // 🟢 새로운 Exercise 객체 생성 (기존 객체를 복사)
                Exercise exercise = new Exercise(
                        baseExercise.getName(),
                        baseExercise.getArea(),
                        baseExercise.getPushPull(),
                        baseExercise.getRepMaxLightWeight(),
                        baseExercise.getRepMaxLightReps(),
                        baseExercise.getRepMaxHeavyWeight(),
                        baseExercise.getRepMaxHeavyReps(),
                        baseExercise.getTool(),
                        baseExercise.isAlternation()
                );

                // 🟢 중량 증가 반영
                exercise.calculateWeight(i);
                exercise.calculateRM();
                exercise.calculateSet(exercise.getRm());

                // 🟢 Schedule과 연결
                exercise.setSchedule(schedule);
                schedule.getExercises().add(exercise);
            }

            // 🟢 다시 저장하여 Exercise 포함
            scheduleRepository.save(schedule);
        }
    }


    @Transactional(readOnly = true)
    public List<ScheduleResponse> getSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll();

        return schedules.stream()
                .map(ScheduleResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ScheduleResponse getScheduleById(Long id) {
        return scheduleRepository.findById(id)
                .map(ScheduleResponse::new)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponse> getScheduleByWeek(int week) {
        List<Schedule> schedules = scheduleRepository.findByWeek(week);

        return schedules.stream()
                .map(ScheduleResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateSchedule(ScheduleUpdateRequest request) {
        List<Schedule> schedules = scheduleRepository.findAll();

        for (Schedule schedule : schedules) {
            schedule.addExercise(request.getExercise());
            scheduleRepository.save(schedule);
        }
    }

    @Transactional
    public void deleteSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        scheduleRepository.delete(schedule);
    }
}