package com.mangementsystem.studentresult_mangement.Service;

import com.mangementsystem.studentresult_mangement.Entity.Branch;
import com.mangementsystem.studentresult_mangement.Entity.Semester;
import com.mangementsystem.studentresult_mangement.Entity.Student;
import com.mangementsystem.studentresult_mangement.Repository.BranchRepository;
import com.mangementsystem.studentresult_mangement.Repository.SemesterRepository;
import com.mangementsystem.studentresult_mangement.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    BranchRepository branchRepository;
    @Autowired
    SemesterRepository semesterRepository;
    public void addStudent(Student student) throws Exception{
        Branch branch;
        try{
            branch = branchRepository.findById(student.getBranch().getId()).get();
        }
        catch (Exception e){
            throw new Exception("Branch not present in this College");
        }

        student.setBranch(branch);

        Semester semester;
        try{
            semester = semesterRepository.findById(student.getSemester().getId()).get();
        }
        catch (Exception e){
            throw new Exception("Semester not present in this college");
        }
        student.setSemester(semester);
        studentRepository.save(student);

    }
    public void generateRollNo(int id){



    }
}
