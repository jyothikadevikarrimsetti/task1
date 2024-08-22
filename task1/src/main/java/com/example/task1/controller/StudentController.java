package com.example.task1.controller;

import com.example.task1.exceptions.BranchNotFoundException;
import com.example.task1.exceptions.DepartmentNotFoundException;
import com.example.task1.exceptions.StudentNotFoundException;
import com.example.task1.model.Branch;
import com.example.task1.model.Departments;
import com.example.task1.model.Faculty;
import com.example.task1.model.Students;
import com.example.task1.projection.StudentBranchProjection;
import com.example.task1.projection.StudentProjection;
import com.example.task1.repository.BranchRepo;
import com.example.task1.repository.DepartmentsRepo;
import com.example.task1.repository.StudentRepo;
import com.example.task1.service.DepartmentService;
import com.example.task1.service.FacultyService;
import com.example.task1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {
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


    @PostMapping("addStudent")
    public Students addStudent(@RequestBody Students students) {

        return service.addStudent(students);

    }

    @GetMapping("getStudent")
    public Students getStudent(@RequestParam("id") int id) {
        return studentRepo.findById(id).orElseThrow(()->new StudentNotFoundException() );
    }

    @GetMapping("allStudents")
    public List<Students> allStudents() {
        return studentRepo.findAll();
    }

    @DeleteMapping("delStudent")
    public ResponseEntity<?> delStudents(int id) {
        Students students = studentRepo.findById(id).orElseThrow(()->new StudentNotFoundException());
        studentRepo.deleteById(id);
        return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
    }

    @PutMapping("updateStudent")
    public Students updateStudent(@RequestBody Students students) {
        Branch branch = branchRepo.findById(students.getBranch().getBranchId()).orElseThrow(()->new BranchNotFoundException());
        Students existStudent = studentRepo.findById(students.getStudentId()).orElseThrow(()->new StudentNotFoundException());
        existStudent.setBranch(branch);
        existStudent.setStudentName(students.getStudentName());
        existStudent.setMobileNumber(students.getMobileNumber());
        return studentRepo.save(existStudent);

    }
        @GetMapping("findAllTables")
        public List<?> findAllTables(){
        return service.projection(studentRepo.findAllTables());
        }

        @PutMapping("setImage")
        public ResponseEntity<?> setImage(@RequestParam ("id") int id , @RequestParam("image")MultipartFile file) throws Exception{
        Departments departments = departmentsRepo.findById(id).orElseThrow(()->new DepartmentNotFoundException());

            departments.setHodImage(file.getBytes());

        return new ResponseEntity<>(departmentsRepo.save(departments),HttpStatus.OK);
        }

    @GetMapping("getImage")
    public ResponseEntity<?> getImage(@RequestParam int id){
        Departments departments = departmentsRepo.findById(id).orElseThrow(()->new DepartmentNotFoundException());
        byte[] img = departments.getHodImage();
        String contentType = "image/jpeg";
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).body(img);
    }


}

