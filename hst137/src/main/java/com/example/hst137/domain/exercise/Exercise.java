package com.example.hst137.domain.exercise;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Setter
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false)
    private String name;

    private String area;

    private String pushPull;

    private double repMaxLightWeight;
    private int repMaxLightReps;

    private double repMaxHeavyWeight;
    private int repMaxHeavyReps;

    private String tool;

    private boolean alternation;

    protected Exercise() {}

    public Exercise(String name, String area, String pushPull, double repMaxLightWeight, int repMaxLightReps, double repMaxHeavyWeight, int repMaxHeavyReps, String tool, boolean alternation) {
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

    public void updateName(String name) {
        this.name = name;
    }

    public void updateArea(String area) {
        this.area = area;
    }

    public void updatePushPull(String pushPull) {
        this.pushPull = pushPull;
    }

    public void updateRepMaxLightWeight(double repMaxLightWeight) {
        this.repMaxLightWeight = repMaxLightWeight;
    }
    public void updateRepMaxLightReps(int repMaxLightReps) {
        this.repMaxLightReps = repMaxLightReps;
    }

    public void updateRepMaxHeavyWeight(double repMaxHeavyWeight) {
        this.repMaxHeavyWeight = repMaxHeavyWeight;
    }
    public void updateRepMaxHeavyReps(int repMaxHeavyReps) {
        this.repMaxHeavyReps = repMaxHeavyReps;
    }

    public void updateTool(String tool) {
        this.tool = tool;
    }

    public void updateAlternation(boolean alternation) {
        this.alternation = alternation;
    }

    @Override
    public String toString() {
        return "Exercise {" +
                "id = " + id +
                "name = " + name +
                "}";
    }
}
