package com.mangementsystem.studentresult_mangement.Service;

import com.mangementsystem.studentresult_mangement.Entity.Branch;
import com.mangementsystem.studentresult_mangement.Entity.Semester;
import com.mangementsystem.studentresult_mangement.Repository.BranchRepository;
import com.mangementsystem.studentresult_mangement.Repository.SemesterRepository;
import com.mangementsystem.studentresult_mangement.RequestDTO.SemesterRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterService {
    @Autowired
    SemesterRepository semesterRepository;
    @Autowired
    BranchRepository branchRepository;
    public void addSem(SemesterRequestDTO semesterRequestDTO){
        Semester semester = new Semester();
        semester.setYear(semesterRequestDTO.getYear());
        semester.setSemNumber(semesterRequestDTO.getSemNumber());

        Branch branch = branchRepository.findByCode(semesterRequestDTO.getBranchCode());
        semester.setBranch(branch);

        List<Semester> semesters = branch.getSemesterList();
        semesters.add((semester));
        branchRepository.save(branch);
    }
}
