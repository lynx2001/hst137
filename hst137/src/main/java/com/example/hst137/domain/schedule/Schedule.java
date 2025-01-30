package com.example.hst137.domain.schedule;

import com.example.hst137.domain.exercise.Exercise;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int week;
    private LocalDate date;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Exercise> exercises = new ArrayList<>();

    protected Schedule() {}

    public Schedule(LocalDate date) {
        this.date = date;
    }

    public Schedule(List<Exercise> exercises, LocalDate date) {
        this.exercises = exercises;

        if(id % 4 == 0)
            this.week = (int) (this.id / 4);
        else
            this.week = (int) (this.id / 4 + 1);

        this.date = date.plusDays(2 * (id - 1));
    }

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }
}
