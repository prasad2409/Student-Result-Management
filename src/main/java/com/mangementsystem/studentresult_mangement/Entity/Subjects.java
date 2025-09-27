package com.mangementsystem.studentresult_mangement.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Subjects {
    private int id;
    private String subjectName;
    private int credits;
    private  String code;
}
