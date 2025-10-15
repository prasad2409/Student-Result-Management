package com.mangementsystem.studentresult_mangement.Service;

import com.mangementsystem.studentresult_mangement.Entity.Branch;
import com.mangementsystem.studentresult_mangement.Repository.BranchRepository;
import com.mangementsystem.studentresult_mangement.RequestDTO.BranchRequestDto;
import com.mangementsystem.studentresult_mangement.ResponseDTO.branchResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public List<branchResponseDTO> getBranches(){
        List<Branch> branches = branchRepository.findAll();
        List<branchResponseDTO> branchResponseDTOS = new ArrayList<>();

        for(Branch b : branches){
            branchResponseDTO branchResponseDTO = new branchResponseDTO();
            branchResponseDTO.setBranchName(b.getBranchName());
            branchResponseDTO.setCode(b.getCode());
            branchResponseDTOS.add(branchResponseDTO);
        }
        return branchResponseDTOS;
    }
}
