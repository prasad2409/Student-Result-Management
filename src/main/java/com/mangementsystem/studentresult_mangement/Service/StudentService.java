package com.mangementsystem.studentresult_mangement.Service;

import com.mangementsystem.studentresult_mangement.Entity.Branch;
import com.mangementsystem.studentresult_mangement.Entity.Semester;
import com.mangementsystem.studentresult_mangement.Entity.Student;
import com.mangementsystem.studentresult_mangement.Repository.BranchRepository;
import com.mangementsystem.studentresult_mangement.Repository.SemesterRepository;
import com.mangementsystem.studentresult_mangement.Repository.StudentRepository;
import com.mangementsystem.studentresult_mangement.RequestDTO.StudentRequestDTO;
import com.mangementsystem.studentresult_mangement.ResponseDTO.allStudentsResponseDTO;
import com.mangementsystem.studentresult_mangement.ResponseDTO.studentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        boolean exists = branch .getStudentList()
                        .stream()
                        .anyMatch(s-> Objects.equals(s.getRollNo(),student.getRollNo()));
        if(exists)
            throw new RuntimeException("Roll Number Already Present "+ rollNo);

        branch.getStudentList().add(student);
        student.setBranch(branch);

        Semester semester = semesterRepository.findBySemNumber(1)
                .stream()
                .filter(s->s.getBranch().getCode().equals(studentRequestDTO.getBranchCode()))
                .findFirst()
                .orElseThrow(()->new RuntimeException("Semester Not Found"));
        semester.getStudentList().add(student);
        student.setSemester(semester);
        studentRepository.save(student);
    }
    public String generateRollNo(String branchCode){
        Branch branch = branchRepository.findByCode(branchCode);

        int index=0;
        List<Student> studentList = branch.getStudentList();
        String lastRollNo = null;

        if(studentList.size()>0){
            index = studentList.size()-1;
            lastRollNo = studentList.get(index).getRollNo();
        }
        else {
            int year = LocalDate.now().getYear();
            return year+branchCode+"01";
        }

        String prefix = lastRollNo.substring(0,lastRollNo.length()-2);
        String last = lastRollNo.substring(lastRollNo.length()-2);

        int next = Integer.parseInt(last);
        next++;

        return prefix+String.format("%02d",next);
    }
    public String deleteStudent(String rollNo){
        Student student = studentRepository.findByRollNo(rollNo);
//        studentRepository.delete(student);
        studentRepository.deleteByRollNo(rollNo);
        return student.getName()+" Left the College !!";
    }
    public List<allStudentsResponseDTO> getAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        List<allStudentsResponseDTO> responseDTO = new ArrayList<>();
        for(Student pre :studentList){
            allStudentsResponseDTO allStudentsResponseDTO = new allStudentsResponseDTO();
            allStudentsResponseDTO.setName(pre.getName());
            allStudentsResponseDTO.setPhoneNo(pre.getPhoneNo());
            allStudentsResponseDTO.setRollNo(pre.getRollNo());
            responseDTO.add(allStudentsResponseDTO);
        }
        return responseDTO;
    }
    public List<allStudentsResponseDTO> getAllStudentsByBranch(String branchCode){
        List<Student> students = branchRepository.findByCode(branchCode).getStudentList();
        List<allStudentsResponseDTO> responseDTO = new ArrayList<>();
        for(Student pre :students){
            allStudentsResponseDTO allStudentsResponseDTO = new allStudentsResponseDTO();
            allStudentsResponseDTO.setName(pre.getName());
            allStudentsResponseDTO.setPhoneNo(pre.getPhoneNo());
            allStudentsResponseDTO.setRollNo(pre.getRollNo());
            responseDTO.add(allStudentsResponseDTO);
        }
        return responseDTO;
    }

    public studentResponseDTO getStudent(String rollNo){
        Student student = studentRepository.findByRollNo(rollNo);
        studentResponseDTO studentResponseDTO = new studentResponseDTO();
        studentResponseDTO.setName(student.getName());
        studentResponseDTO.setPhoneNo(student.getPhoneNo());

        return studentResponseDTO;
    }
}
