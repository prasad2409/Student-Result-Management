package com.mangementsystem.studentresult_mangement.Service;

import com.mangementsystem.studentresult_mangement.Entity.Branch;
import com.mangementsystem.studentresult_mangement.Entity.Semester;
import com.mangementsystem.studentresult_mangement.Entity.Student;
import com.mangementsystem.studentresult_mangement.Repository.BranchRepository;
import com.mangementsystem.studentresult_mangement.Repository.SemesterRepository;
import com.mangementsystem.studentresult_mangement.Repository.StudentRepository;
import com.mangementsystem.studentresult_mangement.RequestDTO.StudentRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    BranchRepository branchRepository;
    @Autowired
    SemesterRepository semesterRepository;
    public void addStudent(StudentRequestDTO studentRequestDTO) {

        Student student = new Student();
        student.setName(studentRequestDTO.getName());
        student.setPhoneNo(studentRequestDTO.getPhoneNo());
        String rollNo = generateRollNo(studentRequestDTO.getBranchCode());
        student.setRollNo(rollNo);

        Branch branch = branchRepository.findByCode(studentRequestDTO.getBranchCode());
        branch.getStudentList().add(student);
        student.setBranch(branch);

        Semester semester = semesterRepository.findBySemNumber(1)
                .stream()
                .filter(s->s.getBranch().getCode().equals(studentRequestDTO.getBranchCode()))
                .findFirst()
                .orElseThrow(()->new RuntimeException("Semester Not Found"));
        semester.getStudentList().add(student);
        student.setSemester(semester);
        branchRepository.save(branch);
    }
    public String generateRollNo(String branchCode){
        Branch branch = branchRepository.findByCode(branchCode);
        int nextRollNo = branch.getStudentList().size()+1;
        int year = LocalDate.now().getYear();
        return year+branchCode+String.format("%02d",nextRollNo);
    }
}
