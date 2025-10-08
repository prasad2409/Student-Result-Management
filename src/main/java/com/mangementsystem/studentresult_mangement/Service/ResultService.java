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
    public String addResult(ResultRequestDTO resultRequestDTO){
        int marks = resultRequestDTO.getMarksScored();
        Result result = new Result();
        result.setMarksScored(resultRequestDTO.getMarksScored());

        if(marks >= 85){
            result.setGrade('A');
            result.setCredits(3);
        }
        else if(marks >=75){
            result.setGrade('B');
            result.setCredits(3);
        }
        else if(marks >=65){
            result.setGrade('C');
            result.setCredits(3);
        }
        else if(marks >=55){
            result.setGrade('D');
            result.setCredits(3);
        }
        else if(marks >=45){
            result.setGrade('E');
            result.setCredits(3);
        }
        else {
            result.setGrade('F');
            result.setCredits(0);
        }

        Subject subject = subjectRepository.findBySubjectCode(resultRequestDTO.getSubjectCode());
        subject.getResultList().add(result);
        result.setSubject(subject);

        Student student =studentRepository.findByRollNo(resultRequestDTO.getRollNo());
        student.getResultList().add(result);
        result.setStudent(student);


        resultRepository.save(result);

        return "Result Added with "+result.getGrade()+" Grade";
    }
}
