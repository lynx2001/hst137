package com.example.hst137.dto.exercise.response;

import com.example.hst137.domain.exercise.Exercise;
import lombok.Getter;

@Getter
public class ExerciseResponse {
    private Long id;
    private String name;
    private String area;
    private String pushPull;
    private double repMaxLightWeight;
    private int repMaxLightReps;
    private double repMaxHeavyWeight;
    private int repMaxHeavyReps;
    private String tool;
    private boolean alternation;


    public ExerciseResponse(Exercise exercise) {
        this.id = exercise.getId();
        this.name = exercise.getName();
        this.area = exercise.getArea();
        this.pushPull = exercise.getPushPull();
        this.repMaxLightWeight = exercise.getRepMaxLightWeight();
        this.repMaxLightReps = exercise.getRepMaxLightReps();
        this.repMaxHeavyWeight = exercise.getRepMaxHeavyWeight();
        this.repMaxHeavyReps = exercise.getRepMaxHeavyReps();
        this.tool = exercise.getTool();
        this.alternation = exercise.isAlternation();

    }
}
