package com.mangementsystem.studentresult_mangement.Controller;

import com.mangementsystem.studentresult_mangement.Entity.Branch;
import com.mangementsystem.studentresult_mangement.RequestDTO.BranchRequestDto;
import com.mangementsystem.studentresult_mangement.ResponseDTO.branchResponseDTO;
import com.mangementsystem.studentresult_mangement.Service.BranchService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchController {
    @Autowired
    BranchService branchService;
    @PostMapping("/add")
    public String addBranch(@RequestBody BranchRequestDto branchRequestDto){
        branchService.addBranch(branchRequestDto);
        return "Branch Add Successfully To The College";
    }
    @GetMapping("/get/all")
    public List<branchResponseDTO> getBranches(){
        return branchService.getBranches();
    }
}
