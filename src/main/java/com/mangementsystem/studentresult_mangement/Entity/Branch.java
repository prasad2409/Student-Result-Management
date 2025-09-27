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
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String branchName;
    @Column(unique = true)
    private String code;
    @OneToMany(mappedBy = "branch",cascade = CascadeType.ALL)
    List<Student> studentList = new ArrayList<>();
    @OneToMany(mappedBy = "branch",cascade = CascadeType.ALL)
    List<Semester> semesterList = new ArrayList<>();

}
