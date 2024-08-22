package com.example.task1.service;

import com.example.task1.exceptions.BranchNotFoundException;
import com.example.task1.exceptions.DepartmentNotFoundException;
import com.example.task1.model.Branch;
import com.example.task1.model.Departments;
import com.example.task1.repository.BranchRepo;
import com.example.task1.repository.DepartmentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    DepartmentsRepo departmentsRepo;

    @Autowired
    BranchRepo branchRepo;

    public Departments setDepartmentDetails(Departments departments){
        Branch branch = branchRepo.findById(departments.getBranch().getBranchId()).orElseThrow(()->new BranchNotFoundException());
        departments.setBranch(branch);
        return departmentsRepo.save(departments);
    }
    public Departments getDepartmentDetails(int id ){
        return departmentsRepo.findById(id).orElseThrow(()->new DepartmentNotFoundException());
    }
}
