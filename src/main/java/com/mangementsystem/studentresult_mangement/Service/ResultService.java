package com.mangementsystem.studentresult_mangement.Service;

import com.mangementsystem.studentresult_mangement.Entity.Result;
import com.mangementsystem.studentresult_mangement.Entity.Student;
import com.mangementsystem.studentresult_mangement.Entity.Subject;
import com.mangementsystem.studentresult_mangement.Repository.ResultRepository;
import com.mangementsystem.studentresult_mangement.Repository.StudentRepository;
import com.mangementsystem.studentresult_mangement.Repository.SubjectRepository;
import com.mangementsystem.studentresult_mangement.RequestDTO.ResultRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService {
    @Autowired
    ResultRepository resultRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    StudentRepository studentRepository;
    public void addResult(ResultRequestDTO resultRequestDTO){
        Result result = new Result();
        result.setMarksScored(resultRequestDTO.getMarksScored());
        result.setGrade(resultRequestDTO.getGrade());
        result.setCredits(resultRequestDTO.getCredits());

        Subject subject = subjectRepository.findBySubjectCode(resultRequestDTO.getSubjectCode());
        subject.getResultList().add(result);
        result.setSubject(subject);
        subjectRepository.save(subject);

        Student student =studentRepository.findByRollNo(resultRequestDTO.getRollNo());
        student.getResultList().add(result);
        result.setStudent(student);

        studentRepository.save(student);
    }
}
