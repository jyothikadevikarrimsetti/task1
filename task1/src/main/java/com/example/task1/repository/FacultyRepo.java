package com.example.task1.repository;

import com.example.task1.model.Faculty;
import com.example.task1.projection.StudentBranchProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface FacultyRepo extends JpaRepository<Faculty , Integer> {
    @Query(value = "select student_name,faculty_name,faculty_subject from students join faculty on students.branch_id= faculty.branch_id",nativeQuery = true)
    List<StudentBranchProjection> getStudentBranches();

    @Query(value = "select  count(student_name) as counts,branch.branch_name,students.branch_id from students join faculty on students.branch_id= faculty.branch_id join branch on students.branch_id=branch.branch_id group by students.branch_id",nativeQuery = true)
    List<StudentBranchProjection> getCountAllStudents();

    @Modifying
    @Query(value = "update faculty set faculty_subject = :subject where faculty_id = :id",nativeQuery = true)
    int updateFaculty(@Param("subject")String subject,@Param("id") int id);





}
