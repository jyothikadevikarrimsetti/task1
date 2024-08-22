package com.example.task1.controller;

import com.example.task1.model.Departments;
import com.example.task1.repository.BranchRepo;
import com.example.task1.repository.DepartmentsRepo;
import com.example.task1.repository.StudentRepo;
import com.example.task1.service.DepartmentService;
import com.example.task1.service.FacultyService;
import com.example.task1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {
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

    @PostMapping("setDepartments")
    public Departments setDepartments(@RequestBody Departments departments){
        return departmentService.setDepartmentDetails(departments);
    }

    @GetMapping("getDepartments")
    public ResponseEntity<?> getDepartments(@RequestParam("id") int id){
        return new ResponseEntity<>(departmentService.getDepartmentDetails(id), HttpStatus.OK);
    }
}
