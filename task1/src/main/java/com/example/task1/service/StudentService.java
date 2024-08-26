package com.example.task1.service;

import com.example.task1.exceptions.BranchNotFoundException;
import com.example.task1.model.Branch;
import com.example.task1.model.Students;
import com.example.task1.projection.StudentBranchProjection;
import com.example.task1.projection.StudentProjection;
import com.example.task1.repository.BranchRepo;
import com.example.task1.repository.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
                .orElseThrow(()->new BranchNotFoundException()); // this return null
        students.setBranch(branch); //this sets foreign key



        return studentRepo.save(students);
    }

    public Branch addBranch(int id , String branch){
       Branch branch1 = Branch.builder().branchName(branch).branchId(id).build();
       return branchRepo.save(branch1);
    }

    public List<StudentProjection> projection(List<StudentBranchProjection> list){
        List<StudentBranchProjection> studs = list;
        List<StudentProjection> detailsList = new ArrayList<>();
        for (StudentBranchProjection stud : studs){
            StudentProjection studentProjection = new StudentProjection();
//            LinkedHashMap<String,Object> nonNullFields = new LinkedHashMap<>();
            if (stud.getStudentId() !=null){
//                nonNullFields.put("Student id",stud.getStudentId());
                studentProjection.setStudentId(stud.getStudentId());
            }
            if (stud.getStudentName() !=null){
//                nonNullFields.put("Student name",stud.getStudentName());
                studentProjection.setStudentName(stud.getStudentName());
            }
            if (stud.getMobileNumber() != null){
//                nonNullFields.put("Mobile number",stud.getMobileNumber());
                studentProjection.setMobileNumber(stud.getMobileNumber());
            }
            if (stud.getBranchId() !=null){
//                nonNullFields.put("Branch id",stud.getBranchId());
                studentProjection.setBranchId(stud.getBranchId());
            }
            if (stud.getBranchName() !=null){
//                nonNullFields.put("Branch name",stud.getBranchName());
                studentProjection.setBranchName(stud.getBranchName());
            }
            if (stud.getFacultyId() !=null){
//                nonNullFields.put("Faculty id",stud.getFacultyId());
                studentProjection.setFacultyId(stud.getFacultyId());
            }
            if (stud.getFacultyName() !=null){
//                nonNullFields.put("Faculty name",stud.getFacultyName());
                studentProjection.setFacultyName(stud.getFacultyName());
            }
            if (stud.getFacultyMobile() !=null){
//                nonNullFields.put("Faculty mobile number",stud.getFacultyMobile());
                studentProjection.setFacultyMobile(stud.getFacultyMobile());
            }
            if (stud.getDepartmentName() !=null){
//                nonNullFields.put("Department name",stud.getDepartmentName());
                studentProjection.setDepartmentName(stud.getDepartmentName());
            }
            if (stud.getDepartmentId() !=null){
//                nonNullFields.put("Department Id",stud.getDepartmentId());
                studentProjection.setDepartmentId(stud.getDepartmentId());
            }
            if (stud.getHodName() !=null){
//                nonNullFields.put("Hod name",stud.getHodName());
                studentProjection.setHodName(stud.getHodName());
            }
            detailsList.add(studentProjection);
        }
        return detailsList;
    }
@Transactional
    public void setStudMarks(Students students){
        int rowsaffected = studentRepo.setStudentMarks(students.getStudentMarks(), students.getStudentId());
        if (rowsaffected>0){
            System.out.println("rows updated");
        }
        else {
            System.out.println("no change");
        }
}

}
