package com.mangementsystem.studentresult_mangement.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentRequestDTO {

    private String phoneNo;
    private String name;
    private String branchCode;
}
