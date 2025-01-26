package com.example.hst137.controller.exercise;

import com.example.hst137.dto.exercise.request.ExerciseCreateRequest;
import com.example.hst137.dto.exercise.request.ExerciseUpdateRequest;
import com.example.hst137.dto.exercise.response.ExerciseResponse;
import com.example.hst137.service.exercise.ExerciseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ExerciseController {
    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }
/*
    @Operation(summary = "Save new exercise")
    @ApiResponse(responseCode = "200OK", description = "Exercise saved successfully")
    @PostMapping("/exercise")
    public ResponseEntity<Map<String, String>> saveExercise(@RequestBody ExerciseCreateRequest request) {
        exerciseService.saveExercise(request);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Exercise saved successfully");
        return ResponseEntity.ok(response);
    }
*/
    @Operation(summary = "Save new exercise")
    @ApiResponse(responseCode = "200OK", description = "Exercise saved successfully")
    @PostMapping("/exercise")
    public ResponseEntity<Void> saveExercise(@RequestBody ExerciseCreateRequest request) {
        exerciseService.saveExercise(request);
        return ResponseEntity.ok().build(); // 200 OK 응답만 반환
    }

    @Operation(summary = "Get All Exercises", description = "Return list of all saved exercised.")
    @ApiResponse(responseCode = "200OK", description = "List of exercises retrieved successfully")
    @GetMapping("/exercise")
    public List<ExerciseResponse> getExercises() {
        return exerciseService.getExercises();
    }

    @Operation(summary = "Get exercise by ID", description = "Returns the details of a specific exercise by its ID.")
    @ApiResponse(responseCode = "200OK", description = "Exercise details retrieved successfully")
    @GetMapping("/exercise/{id}")
    public ExerciseResponse getExercise(@PathVariable Long id) {
        return exerciseService.getExerciseById(id);
    }

    @Operation(summary = "Get exercise by name", description = "Returns the details of a specific exercise by its name.")
    @ApiResponse(responseCode = "200OK", description = "Exercise details retrieved successfully")
    @GetMapping(value = "/exercise", params = "name")
    public ExerciseResponse getExercise(@RequestParam String name) {
        return exerciseService.getExerciseByName(name);
    }

    @Operation(summary = "Update an exercise", description = "Updates an existing exercise with new details.")
    @ApiResponse(responseCode = "200OK", description = "Exercise updated successfully")
    @PutMapping("/exercise")
    public void updateExercise(@RequestBody ExerciseUpdateRequest request) {
        exerciseService.updateExercise(request);
    }

    @Operation(summary = "Delete an exercise by ID", description = "Deletes an exercise by its ID.")
    @ApiResponse(responseCode = "200OK", description = "Exercise deleted successfully")
    @DeleteMapping(value = "/exercise", params = "id")
    public void deleteExercise(@RequestParam Long id) {
        exerciseService.deleteExercise(id);
    }

    @Operation(summary = "Delete an exercise by name", description = "Deletes an exercise by its name.")
    @ApiResponse(responseCode = "200OK", description = "Exercise deleted successfully")
    @DeleteMapping(value = "/exercise", params = "name")
    public void deleteExercise(@RequestParam String name) {
        exerciseService.deleteExercise(name);
    }
}
