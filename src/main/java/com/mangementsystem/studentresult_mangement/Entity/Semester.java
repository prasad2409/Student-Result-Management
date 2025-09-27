package com.mangementsystem.studentresult_mangement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int year;
    private int semNumber;
    @ManyToOne
    @JoinColumn(name = "branch_id")
    Branch branch;
    @OneToMany(mappedBy = "semester",cascade = CascadeType.ALL)
    List<Student> studentList = new ArrayList<>();
}
