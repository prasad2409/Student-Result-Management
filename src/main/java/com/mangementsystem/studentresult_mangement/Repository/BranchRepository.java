package com.mangementsystem.studentresult_mangement.Repository;

import com.mangementsystem.studentresult_mangement.Entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Integer> {

    Branch findByCode(String code);
    Branch findByBranchName(String name);
}
