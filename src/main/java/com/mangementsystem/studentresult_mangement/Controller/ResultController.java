package com.mangementsystem.studentresult_mangement.Controller;

import com.mangementsystem.studentresult_mangement.RequestDTO.ResultRequestDTO;
import com.mangementsystem.studentresult_mangement.Service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/result")
public class ResultController {
    @Autowired
    ResultService resultService;
    @PostMapping("/add")
    public String addResult(@RequestBody ResultRequestDTO resultRequestDTO){
        resultService.addResult(resultRequestDTO);
        return "Result is Added!";
    }
}
