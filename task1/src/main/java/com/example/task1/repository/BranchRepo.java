package com.example.task1.repository;

import com.example.task1.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepo extends JpaRepository<Branch,Integer> {
}
