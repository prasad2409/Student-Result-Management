package com.mangementsystem.studentresult_mangement.Controller;

import com.mangementsystem.studentresult_mangement.Entity.Semester;
import com.mangementsystem.studentresult_mangement.RequestDTO.SemesterRequestDTO;
import com.mangementsystem.studentresult_mangement.Service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/semester")
public class SemesterController {
    @Autowired
    SemesterService semesterService;
    @PostMapping("/add")
    public String addSem(@RequestBody SemesterRequestDTO semesterRequestDTO) throws Exception{
        semesterService.addSem(semesterRequestDTO);
        return "Semester is Add";
    }
}
