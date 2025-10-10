package com.mangementsystem.studentresult_mangement.Controller;

import com.mangementsystem.studentresult_mangement.Entity.Student;
import com.mangementsystem.studentresult_mangement.RequestDTO.StudentRequestDTO;
import com.mangementsystem.studentresult_mangement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
