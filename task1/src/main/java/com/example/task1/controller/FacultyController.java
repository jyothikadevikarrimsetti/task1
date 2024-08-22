package com.example.task1.controller;

import com.example.task1.model.Faculty;
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
public class FacultyController {
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
    @PostMapping("setFaculty")
    public Faculty setFaculty(@RequestBody Faculty faculty){
        return facultyService.setFacultyDetails(faculty);
    }
    @GetMapping("getFaculty")
    public ResponseEntity<?> getFaculty(@RequestParam("id") int id){
        return new ResponseEntity<>( facultyService.getFacultyDetails(id), HttpStatus.OK);

    }
}
