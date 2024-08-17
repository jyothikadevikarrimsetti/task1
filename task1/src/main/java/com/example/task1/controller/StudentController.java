package com.example.task1.controller;

import com.example.task1.model.Branch;
import com.example.task1.model.Students;
import com.example.task1.repository.BranchRepo;
import com.example.task1.repository.StudentRepo;
import com.example.task1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    BranchRepo branchRepo;
    @Autowired
    StudentService service;

    @PostMapping("addStudent")
    public Students addStudent(@RequestBody Students students) {

        return service.addStudent(students);

    }

    @GetMapping("getStudent")
    public Students getStudent(@RequestParam("id") int id) {
        return studentRepo.findById(id).orElse(new Students());
    }

    @GetMapping("allStudents")
    public List<Students> allStudents() {
        return studentRepo.findAll();
    }

    @DeleteMapping("delStudent")
    public String delStudents(int id) {
        studentRepo.deleteById(id);
        return "Success";
    }

    @PutMapping("updateStudent")
    public Students updateStudent(@RequestBody Students students) {
        Branch branch = branchRepo.findById(students.getBranch().getBranchId()).orElse(null);
        Students existStudent = studentRepo.findById(students.getStudentId()).orElseThrow(()->new RuntimeException("student not found"));
        existStudent.setBranch(branch);
        existStudent.setStudentName(students.getStudentName());
        existStudent.setMobileNumber(students.getMobileNumber());
        return studentRepo.save(existStudent);

    }
}

