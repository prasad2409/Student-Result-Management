package com.mangementsystem.studentresult_mangement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subjectName;
    private int credits;
    @Column(unique = true)
    private  String subjectCode;
    private int max_Marks;
    @ManyToOne
    @JoinColumn(name = "semester_id")
    Semester semester;
    @OneToMany(mappedBy = "subject",cascade = CascadeType.ALL)
    List<Result> resultList = new ArrayList<>();
}
