package com.example.task1.service;

import com.example.task1.exceptions.BranchNotFoundException;
import com.example.task1.exceptions.FacultyNotFoundException;
import com.example.task1.model.Branch;
import com.example.task1.model.Faculty;
import com.example.task1.repository.BranchRepo;
import com.example.task1.repository.FacultyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {
    @Autowired
    FacultyRepo facultyRepo;

    @Autowired
    BranchRepo branchRepo;

    public Faculty setFacultyDetails(Faculty faculty){
        Branch branch = branchRepo.findById(faculty.getBranch().getBranchId()).orElseThrow(()->new BranchNotFoundException());
       faculty.setBranch(branch);
       return facultyRepo.save(faculty);
    }
    public Faculty getFacultyDetails(int id ){
     return facultyRepo.findById(id).orElseThrow(()-> new FacultyNotFoundException());
    }
}
