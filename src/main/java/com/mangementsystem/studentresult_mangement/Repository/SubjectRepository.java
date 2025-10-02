package com.mangementsystem.studentresult_mangement.Repository;

import com.mangementsystem.studentresult_mangement.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer> {

    Subject findBySubjectCode(String SubjectCode);
}
