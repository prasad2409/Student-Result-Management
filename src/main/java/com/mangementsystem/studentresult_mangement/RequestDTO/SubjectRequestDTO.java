package com.mangementsystem.studentresult_mangement.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubjectRequestDTO {
    private String subjectName;
    private int credits;
    private  String subjectCode;
    private int max_Marks;
    private String branchCode;
    private int semNumber;
}
