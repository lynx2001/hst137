package com.example.hst137.dto.exercise.request;

import lombok.Getter;

@Getter
public class ExerciseCreateRequest {
    private String name;
    private String area;
    private String pushPull;
    private double repMaxLightWeight;
    private int repMaxLightReps;
    private double repMaxHeavyWeight;
    private int repMaxHeavyReps;
    private String tool;
    private boolean alternation;

    public ExerciseCreateRequest(String name, String area, String pushPull, double repMaxLightWeight, int repMaxLightReps, double repMaxHeavyWeight, int repMaxHeavyReps, String tool, boolean alternation) {
        this.name = name;
        this.area = area;
        this.pushPull = pushPull;
        this.repMaxLightWeight = repMaxLightWeight;
        this.repMaxLightReps = repMaxLightReps;
        this.repMaxHeavyWeight = repMaxHeavyWeight;
        this.repMaxHeavyReps = repMaxHeavyReps;
        this.tool = tool;
        this.alternation = alternation;
    }
}
