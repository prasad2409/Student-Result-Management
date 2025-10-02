package com.mangementsystem.studentresult_mangement.Controller;

import com.mangementsystem.studentresult_mangement.RequestDTO.SubjectRequestDTO;
import com.mangementsystem.studentresult_mangement.ResponseDTO.SubjectResponseDTO;
import com.mangementsystem.studentresult_mangement.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;
    @PostMapping("/add")
    public String addSubject(@RequestBody SubjectRequestDTO subjectRequestDTO){
        SubjectResponseDTO subjectResponseDTO= subjectService.addSubject(subjectRequestDTO);
        return "Subject Added to the branch of "+subjectResponseDTO.getBranchName()+" in semester "+subjectResponseDTO.getSemNumber();
    }
}
