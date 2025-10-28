package com.mangementsystem.studentresult_mangement.Service;

import com.mangementsystem.studentresult_mangement.Entity.Result;
import com.mangementsystem.studentresult_mangement.Entity.Student;
import com.mangementsystem.studentresult_mangement.Entity.Subject;
import com.mangementsystem.studentresult_mangement.Repository.ResultRepository;
import com.mangementsystem.studentresult_mangement.Repository.StudentRepository;
import com.mangementsystem.studentresult_mangement.Repository.SubjectRepository;
import com.mangementsystem.studentresult_mangement.RequestDTO.ResultRequestDTO;
import com.mangementsystem.studentresult_mangement.ResponseDTO.allResultsResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public List<allResultsResponseDTO> getAllResults(){
        List<allResultsResponseDTO> allResultsResponseDTOS = new ArrayList<>();
        List<Result> results = resultRepository.findAll();
        for(Result r : results){
            allResultsResponseDTO allResultsResponseDTO = new allResultsResponseDTO();
            allResultsResponseDTO.setMarksScored(r.getMarksScored());
            allResultsResponseDTO.setCredits(r.getCredits());
            allResultsResponseDTO.setGrade(r.getGrade());

            Student student = r.getStudent();
            allResultsResponseDTO.setStudentName(student.getName());
            allResultsResponseDTO.setStudentRollNo(student.getRollNo());

            Subject subject = r.getSubject();
            allResultsResponseDTO.setSubjectName(subject.getSubjectName());

            allResultsResponseDTOS.add(allResultsResponseDTO);
        }
        return allResultsResponseDTOS;
    }
    public List<allResultsResponseDTO> getStudentResult(String rollNo){
        Student student = studentRepository.findByRollNo(rollNo);
        List<allResultsResponseDTO> allResultsResponseDTOS = new ArrayList<>();
        List<Result> results = student.getResultList();

        for(Result r : results){
            allResultsResponseDTO allResultsResponseDTO = new allResultsResponseDTO();
            allResultsResponseDTO.setStudentName(student.getName());
            allResultsResponseDTO.setStudentRollNo(student.getRollNo());

            Subject subject = r.getSubject();
            allResultsResponseDTO.setSubjectName(subject.getSubjectName());

            allResultsResponseDTO.setMarksScored(r.getMarksScored());
            allResultsResponseDTO.setGrade(r.getGrade());
            allResultsResponseDTO.setCredits(r.getCredits());

            allResultsResponseDTOS.add(allResultsResponseDTO);
        }
        return allResultsResponseDTOS;

    }
}
