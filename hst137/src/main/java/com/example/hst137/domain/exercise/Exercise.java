package com.example.hst137.domain.exercise;

import com.example.hst137.domain.schedule.Schedule;
import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Column(nullable = false, name = "name") //unique = true)
    private String name;

    @Column(name = "area")
    private String area;

    @Column(name = "push_pull")
    private String pushPull;

    @Column(name = "rep_max_light_weight")
    private double repMaxLightWeight;
    @Column(name = "rep_max_light_reps")
    private int repMaxLightReps;

    @Column(name = "rep_max_heavy_weight")
    private double repMaxHeavyWeight;
    @Column(name = "rep_max_heavy_reps")
    private int repMaxHeavyReps;

    @Column(name = "tool")
    private String tool;

    @Column(name = "alternation")
    private boolean alternation;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    @JsonBackReference
    private Schedule schedule;

    private double slope;
    private double intercept;
    private double increment;
    @Column(name = "one_rm")
    private double oneRM;

    private double weight;
    private double rm;
    private String sets;

    private double firstSessionWeight;
    private double lastSessionWeight;
    private double incrementWeight;

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

        slope = (repMaxHeavyWeight - repMaxLightWeight) / (repMaxHeavyReps - repMaxLightReps);
        intercept = repMaxHeavyWeight - (slope * repMaxHeavyReps);
        increment = (95.0 - 58.0) / (31 - 1);
        oneRM = repsWeight(1);
        firstSessionWeight = oneRM * 0.58;
        lastSessionWeight = oneRM * 0.95;
        incrementWeight = (lastSessionWeight - firstSessionWeight) / (31 - 1);
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


    public double repsWeight(int reps) {
        return intercept + (slope * reps);
    }

    public void calculateWeight(int i) {
        this.weight = firstSessionWeight + incrementWeight * i;
    }

    public void calculateRM() {
        this.rm = weight/oneRM * 100;
    }

    public void calculateSet(double rm) {
        if(rm >= 99)
            this.sets = "1, 1, 1";
        else if(rm >= 98)
            this.sets = "1, 1, 1, 1";
        else if(rm >= 97)
            this.sets = "2, 1, 1, 1, 1";
        else if(rm >= 96)
            this.sets = "2, 2, 1, 1, 1";
        else if(rm >= 95)
            this.sets = "2, 2, 1, 1, 1, 1";
        else if(rm >= 94)
            this.sets = "2, 2, 2, 2, 2";
        else if(rm >= 93)
            this.sets = "3, 2, 2, 2, 2";
        else if(rm >= 92)
            this.sets = "3, 3, 2, 2, 2";
        else if(rm >= 91)
            this.sets = "4, 3, 3, 2, 2";
        else if(rm >= 88)
            this.sets = "4, 4, 4, 4, 4";
        else if(rm >= 86)
            this.sets = "5, 4, 4, 4, 3";
        else if(rm >= 83)
            this.sets = "5, 5, 5 ,5";
        else if(rm >= 82)
            this.sets = "6, 5, 5, 4";
        else if(rm >= 80)
            this.sets = "6, 6, 4, 4";
        else if(rm >= 76)
            this.sets = "7, 7, 6";
        else if(rm >= 72)
            this.sets = "8, 7, 5";
        else if(rm >= 70)
            this.sets = "9, 9, 2";
        else if(rm >= 67)
            this.sets = "10, 10";
        else if(rm >= 64)
            this.sets = "11, 9";
        else if(rm >= 62)
            this.sets = "12, 8";
        else
            this.sets = "13, 7";
    }

    @Override
    public String toString() {
        return "Exercise {" +
                "id = " + id +
                "name = " + name +
                "}";
    }
}
