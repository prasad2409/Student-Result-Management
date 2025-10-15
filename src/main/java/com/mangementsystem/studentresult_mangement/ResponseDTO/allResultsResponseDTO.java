package com.mangementsystem.studentresult_mangement.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class allResultsResponseDTO {
    private String studentName;
    private String studentRollNo;
    private String subjectName;
    private int marksScored;
    private char grade;
    private int credits;

}
