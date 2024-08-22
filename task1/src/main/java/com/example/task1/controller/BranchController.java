package com.example.task1.controller;

import com.example.task1.exceptions.StudentNotFoundException;
import com.example.task1.projection.StudentBranchProjection;
import com.example.task1.projection.StudentProjection;
import com.example.task1.repository.BranchRepo;
import com.example.task1.repository.DepartmentsRepo;
import com.example.task1.repository.StudentRepo;
import com.example.task1.service.DepartmentService;
import com.example.task1.service.FacultyService;
import com.example.task1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class BranchController {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    BranchRepo branchRepo;
    @Autowired
    DepartmentsRepo departmentsRepo;
    @Autowired
    StudentService service;
    @Autowired
    FacultyService facultyService;
    @Autowired
    DepartmentService departmentService;

    @GetMapping("studentBranch")
    public StudentProjection studentBranch(@RequestParam("id") int id){
        studentRepo.findById(id).orElseThrow(()->new StudentNotFoundException());
        List<StudentBranchProjection> list1 = new ArrayList<>();
        list1.add(studentRepo .findStudentBranch(id));
        return service.projection(list1).get(0);
    }

    @GetMapping("studentBranches")
    public List<?> studentBranches(){

        return service.projection(studentRepo.findStudentBranch(StudentBranchProjection.class));
    }
}
