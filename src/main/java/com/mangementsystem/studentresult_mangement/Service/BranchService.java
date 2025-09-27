package com.mangementsystem.studentresult_mangement.Service;

import com.mangementsystem.studentresult_mangement.Entity.Branch;
import com.mangementsystem.studentresult_mangement.Repository.BranchRepository;
import com.mangementsystem.studentresult_mangement.RequestDTO.BranchRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchService {
    @Autowired
    BranchRepository branchRepository;
    public void addBranch(BranchRequestDto branchRequestDto){

        Branch branch = new Branch();
        branch.setBranchName(branchRequestDto.getBranchName());
        branch.setCode(branchRequestDto.getCode());
        branchRepository.save(branch);
    }
}
