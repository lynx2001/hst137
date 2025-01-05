package com.example.hst137.dto.exercise.request;

import lombok.Getter;

@Getter
public class ExerciseUpdateRequest {
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
}
