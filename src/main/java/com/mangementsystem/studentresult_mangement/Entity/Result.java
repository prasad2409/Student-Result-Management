package com.mangementsystem.studentresult_mangement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int marksScored;
    private char grade;
    private int credits;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    Subject subject;
    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;
}
