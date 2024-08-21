package com.example.task1.controller;

import com.example.task1.model.Branch;
import com.example.task1.model.Departments;
import com.example.task1.model.Faculty;
import com.example.task1.model.Students;
import com.example.task1.projection.StudentBranchProjection;
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
    @GetMapping("studentBranch")
    public Object studentBranch(@RequestParam ("id") int id){
        return studentRepo.findStudentBranch(id);
    }
    @GetMapping("studentBranches")
    public List<?> studentBranches(){

        return service.projection(studentRepo.findStudentBranch());
    }

    @PostMapping("setFaculty")
    public Faculty setFaculty(@RequestBody Faculty faculty){
        return facultyService.setFacultyDetails(faculty);
    }
    @PostMapping("setDepartments")
    public Departments setDepartments(@RequestBody Departments departments){
        return departmentService.setDepartmentDetails(departments);
    }

    @GetMapping("getFaculty")
    public ResponseEntity<?> getFaculty(@RequestParam("id") int id){
        try {
            return new ResponseEntity<>( facultyService.getFacultyDetails(id),HttpStatus.OK);
        }catch (RuntimeException re){
            return new ResponseEntity<>("not found",HttpStatus.NOT_FOUND);
        }catch (Exception exc){
            return new ResponseEntity<>("internal error",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("getDepartments")
    public ResponseEntity<?> getDepartments(@RequestParam("id") int id){
        try {

            return new ResponseEntity<>(departmentService.getDepartmentDetails(id), HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }catch (Exception exc){
            return new ResponseEntity<>("internal error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        }

        @GetMapping("findAllTables")
        public List<?> findAllTables(){
        return service.projection(studentRepo.findAllTables());
        }

        @PutMapping("setImage")
    public ResponseEntity<?> setImage(@RequestParam ("id") int id , @RequestParam("image")MultipartFile file){
        Departments departments = departmentsRepo.findById(id).orElseThrow(()->new RuntimeException("Dept not found"));
        try {
            departments.setHodImage(file.getBytes());
        }catch (IOException ioe){

        }
        return new ResponseEntity<>(departmentsRepo.save(departments),HttpStatus.OK);
        }

    @GetMapping("getImage")
    public ResponseEntity<?> getImage(@RequestParam int id){
        Departments departments = departmentsRepo.findById(id).orElseThrow(null);
        byte[] img = departments.getHodImage();
        String contentType = "image/jpeg";
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).body(img);
    }


}

