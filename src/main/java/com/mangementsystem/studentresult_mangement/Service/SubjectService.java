package com.mangementsystem.studentresult_mangement.Service;

import com.mangementsystem.studentresult_mangement.Entity.Branch;
import com.mangementsystem.studentresult_mangement.Entity.Semester;
import com.mangementsystem.studentresult_mangement.Entity.Subject;
import com.mangementsystem.studentresult_mangement.Repository.BranchRepository;
import com.mangementsystem.studentresult_mangement.Repository.SemesterRepository;
import com.mangementsystem.studentresult_mangement.Repository.SubjectRepository;
import com.mangementsystem.studentresult_mangement.RequestDTO.SubjectRequestDTO;
import com.mangementsystem.studentresult_mangement.ResponseDTO.SubjectResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    BranchRepository branchRepository;
    @Autowired
    SemesterRepository semesterRepository;
    public SubjectResponseDTO addSubject(SubjectRequestDTO subjectRequestDTO){
        Subject subject = new Subject();
        subject.setSubjectName(subjectRequestDTO.getSubjectName());
        subject.setCredits(subjectRequestDTO.getCredits());
        subject.setSubjectCode(subjectRequestDTO.getSubjectCode());
        subject.setMax_Marks(subjectRequestDTO.getMax_Marks());

        Branch branch = branchRepository.findByCode(subjectRequestDTO.getBranchCode());

        Semester semester = semesterRepository.findBySemNumber(subjectRequestDTO.getSemNumber())
                .stream()
                .filter(s->s.getBranch().getCode().equals(subjectRequestDTO.getBranchCode()))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Semester not Found"));

        semester.getSubjectsList().add(subject);// Adding subject to the semester (many to One)
        subject.setSemester(semester); // Connecting subject and student(one to one)
        semesterRepository.save(semester);

        SubjectResponseDTO subjectResponseDTO = new SubjectResponseDTO();
        subjectResponseDTO.setBranchName(branch.getBranchName());
        subjectResponseDTO.setSemNumber(semester.getSemNumber());

        return subjectResponseDTO;
    }
}
