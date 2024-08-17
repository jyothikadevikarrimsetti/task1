package com.example.task1.service;

import com.example.task1.model.Branch;
import com.example.task1.model.Students;
import com.example.task1.repository.BranchRepo;
import com.example.task1.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    @Autowired
    BranchRepo branchRepo;

    public Students addStudent(Students students){

        Branch branch = branchRepo.findById(students
                .getBranch() //this returns branch from student
                .getBranchId()) // this returns branch id from branch
                .orElse(null); // this return null
        students.setBranch(branch); //this sets foreign key



        return studentRepo.save(students);
    }

    public Branch addBranch(int id , String branch){
       Branch branch1 = Branch.builder().branchName(branch).branchId(id).build();
       return branchRepo.save(branch1);
    }


}
