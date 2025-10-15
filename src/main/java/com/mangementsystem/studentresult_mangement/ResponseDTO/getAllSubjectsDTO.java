package com.mangementsystem.studentresult_mangement.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class getAllSubjectsDTO {
    private String subjectName;
    private int credits;
    private String subjectCode;
    private int marks;
}
