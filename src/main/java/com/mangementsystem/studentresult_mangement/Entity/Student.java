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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String phoneNo;
    private String name;
    @Column(unique = true)
    private String rollNo;
    @ManyToOne
    @JoinColumn(name = "branch_Id")
    Branch branch;
    @ManyToOne
    @JoinColumn
    Semester semester;
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    List<Result> resultList = new ArrayList<>();
}
