package com.example.hst137.domain.schedule;

import com.example.hst137.domain.exercise.Exercise;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int week;
    private Date date;

    private String exerciseName;
    private String weight;
    private String set;
    private double rm;

    protected Schedule() {}


}
