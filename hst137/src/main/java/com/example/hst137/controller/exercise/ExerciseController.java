package com.example.hst137.controller.exercise;

import com.example.hst137.dto.exercise.request.ExerciseCreateRequest;
import com.example.hst137.dto.exercise.request.ExerciseUpdateRequest;
import com.example.hst137.dto.exercise.response.ExerciseResponse;
import com.example.hst137.service.exercise.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExerciseController {
    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping("/exercise")
    public void saveExercise(@RequestBody ExerciseCreateRequest request) {
        exerciseService.saveExercise(request);
    }

    @GetMapping("/exercise")
    public List<ExerciseResponse> getExercises() {
        return exerciseService.getExercises();
    }

    @GetMapping("/exercise/{id}")
    public ExerciseResponse getExercise(@PathVariable Long id) {
        return exerciseService.getExerciseById(id);
    }

    @PutMapping("/exercise")
    public void updateExercise(@RequestBody ExerciseUpdateRequest request) {
        exerciseService.updateExercise(request);
    }

    @DeleteMapping("/exercise")
    public void deleteExercise(@RequestParam Long id) {
        exerciseService.deleteExercise(id);
    }
}
