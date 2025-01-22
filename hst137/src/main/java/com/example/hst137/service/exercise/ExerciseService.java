package com.example.hst137.service.exercise;

import com.example.hst137.domain.exercise.Exercise;
import com.example.hst137.domain.exercise.ExerciseRepository;
import com.example.hst137.dto.exercise.request.ExerciseCreateRequest;
import com.example.hst137.dto.exercise.request.ExerciseUpdateRequest;
import com.example.hst137.dto.exercise.response.ExerciseResponse;
import com.example.hst137.repository.exercise.ExerciseJdbcRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final ExerciseJdbcRepository exerciseJdbcRepository;

    public ExerciseService(ExerciseRepository exerciseRepository, ExerciseJdbcRepository exerciseJdbcRepository) {
        this.exerciseRepository = exerciseRepository;
        this.exerciseJdbcRepository = exerciseJdbcRepository;
    }

    //운동 생성
    @Transactional
    public void saveExercise(ExerciseCreateRequest request) {
        Exercise exercise = new Exercise(
                request.getName(),
                request.getArea(),
                request.getPushPull(),
                request.getRepMaxLightWeight(),
                request.getRepMaxLightReps(),
                request.getRepMaxHeavyWeight(),
                request.getRepMaxHeavyReps(),
                request.getTool(),
                request.isAlternation());

        System.out.println("Exercise Created" + exercise);
        exerciseRepository.save(exercise);
    }

    //운동 목록 조회
    @Transactional(readOnly = true)
    public List<ExerciseResponse> getExercises() {
        List<Exercise> exercises = exerciseRepository.findAll();
        return exercises.stream()
                .map(ExerciseResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ExerciseResponse getExerciseById(Long id) {
        return exerciseRepository.findById(id)
                .map(ExerciseResponse::new)
                .orElseThrow(IllegalArgumentException::new);
    }

    //운동 수정
    @Transactional
    public void updateExercise(ExerciseUpdateRequest request) {
        Exercise exercise = exerciseRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);

        exercise.updateName(request.getName());
        exercise.updateArea(request.getArea());
        exercise.updatePushPull(request.getPushPull());
        exercise.updateRepMaxLightWeight(request.getRepMaxLightWeight());
        exercise.updateRepMaxLightReps(request.getRepMaxLightReps());
        exercise.updateRepMaxHeavyWeight(request.getRepMaxHeavyWeight());
        exercise.updateRepMaxHeavyReps(request.getRepMaxHeavyReps());
        exercise.updateTool(request.getTool());
        exercise.updateAlternation(request.isAlternation());

        exerciseRepository.save(exercise);
    }

    //운동 삭제
    @Transactional
    public void deleteExercise(Long id) {
        Exercise exercise = exerciseRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        exerciseRepository.delete(exercise);
    }
}
