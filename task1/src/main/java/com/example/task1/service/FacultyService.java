package com.example.task1.service;

import com.example.task1.exceptions.BranchNotFoundException;
import com.example.task1.exceptions.FacultyNotFoundException;
import com.example.task1.model.Branch;
import com.example.task1.model.Faculty;
import com.example.task1.repository.BranchRepo;
import com.example.task1.repository.FacultyRepo;
import jakarta.transaction.Transactional;
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

    @Transactional
    public void setFacultySubject(Faculty faculty){
        int rowseffected = facultyRepo.updateFaculty(faculty.getFacultySubject(), faculty.getFacultyId());
        if (rowseffected>0){
            System.out.println("rows updated");
        }
        else {
            System.out.println("no changes");
        }
    }

}
