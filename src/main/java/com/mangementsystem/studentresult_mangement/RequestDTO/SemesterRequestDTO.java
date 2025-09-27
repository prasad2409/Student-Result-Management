package com.mangementsystem.studentresult_mangement.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SemesterRequestDTO {
    private int year;
    private int semNumber;
    private String branchCode;
}
