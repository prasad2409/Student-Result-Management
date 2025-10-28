package com.mangementsystem.studentresult_mangement.Controller;

import com.mangementsystem.studentresult_mangement.Exception.ResourceNotFoundException;
import com.mangementsystem.studentresult_mangement.RequestDTO.ResultRequestDTO;
import com.mangementsystem.studentresult_mangement.ResponseDTO.allResultsResponseDTO;
import com.mangementsystem.studentresult_mangement.Service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/result")
public class ResultController {
    @Autowired
    ResultService resultService;
    @PostMapping("/add")
    public String addResult(@RequestBody ResultRequestDTO resultRequestDTO){
        return resultService.addResult(resultRequestDTO);
    }
    @GetMapping("/get/all")
    public List<allResultsResponseDTO> getAllResults(){
        return resultService.getAllResults();
    }
    @GetMapping("get/student/{rollNo}")
    public List<allResultsResponseDTO> getStudentResult(@PathVariable String rollNo) throws Exception {
        try {
            return resultService.getStudentResult(rollNo);
        }
        catch (Exception e){
            throw new ResourceNotFoundException("Not found student with roll number "+rollNo);
        }
    }
}
