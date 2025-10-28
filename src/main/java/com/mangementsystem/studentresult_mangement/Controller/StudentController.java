package com.mangementsystem.studentresult_mangement.Controller;

import com.mangementsystem.studentresult_mangement.RequestDTO.StudentRequestDTO;
import com.mangementsystem.studentresult_mangement.Exception.ResourceNotFoundException;
import com.mangementsystem.studentresult_mangement.ResponseDTO.allStudentsResponseDTO;
import com.mangementsystem.studentresult_mangement.ResponseDTO.studentResponseDTO;
import com.mangementsystem.studentresult_mangement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        studentService.addStudent(studentRequestDTO);
        return studentRequestDTO.getName()+" Joined in College ";
    }
    @DeleteMapping("/delete/{rollNo}")
    public String deleteStudent(@PathVariable String rollNo){
        return studentService.deleteStudent(rollNo);
    }
    @GetMapping("/All/Branch/{code}")
    public List<allStudentsResponseDTO> getAllStudentsByBranch(@PathVariable String code){
        return studentService.getAllStudentsByBranch(code);
    }
    @GetMapping("/All")
    public List<allStudentsResponseDTO> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/get/{rollNo}")
    public studentResponseDTO getStudent(@PathVariable String rollNo) throws Exception{
        try{
            return studentService.getStudent(rollNo);
        }
        catch (Exception e){
            throw new ResourceNotFoundException("Student Not Found with Roll No "+ rollNo);
        }
    }

}
