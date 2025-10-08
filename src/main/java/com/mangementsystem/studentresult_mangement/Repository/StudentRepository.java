package com.mangementsystem.studentresult_mangement.Repository;

import com.mangementsystem.studentresult_mangement.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

   Student findByRollNo(String rollNo);

}
