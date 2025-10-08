package com.mangementsystem.studentresult_mangement.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResultRequestDTO {
    private String rollNo;
    private String subjectCode;
    private int marksScored;
}
