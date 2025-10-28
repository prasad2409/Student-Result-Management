package com.mangementsystem.studentresult_mangement.Controller;

import com.mangementsystem.studentresult_mangement.RequestDTO.SubjectRequestDTO;
import com.mangementsystem.studentresult_mangement.ResponseDTO.SubjectResponseDTO;
import com.mangementsystem.studentresult_mangement.ResponseDTO.getAllSubjectsDTO;
import com.mangementsystem.studentresult_mangement.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;
    @PostMapping("/add")
    public String addSubject(@RequestBody SubjectRequestDTO subjectRequestDTO){
        return subjectService.addSubject(subjectRequestDTO);
    }
    @GetMapping("/get/all")
    public List<getAllSubjectsDTO> getAllSubjects(){
        return subjectService.getAllSubjects();
    }
    @GetMapping("/get/{branch}/{semester}")
    public List<SubjectResponseDTO> getSubjectByBranchSem(@PathVariable String branch,@PathVariable int semester){
        return subjectService.getSubjectByBranchSem(branch,semester);
    }
}
