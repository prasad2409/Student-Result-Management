package com.mangementsystem.studentresult_mangement.ResponseDTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubjectResponseDTO {
    private String subjectName;
    private int credits;
    private  String subjectCode;
    private int max_Marks;
}
