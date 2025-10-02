package com.mangementsystem.studentresult_mangement.Repository;

import com.mangementsystem.studentresult_mangement.Entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result,Integer> {
}
