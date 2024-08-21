package com.example.task1.repository;

import com.example.task1.model.Students;
import com.example.task1.projection.StudentBranchProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepo extends JpaRepository<Students,Integer> {
    @Query(value = "SELECT student_name,branch_name FROM students join branch on students.branch_id = branch.branch_id WHERE student_id = :id", nativeQuery = true)
    Object findStudentBranch(@Param("id") int id);

    @Query(value = "SELECT * FROM students join branch on students.branch_id = branch.branch_id ", nativeQuery = true)
    List<StudentBranchProjection> findStudentBranch();

    @Query(value = "SELECT * FROM students join branch on students.branch_id = branch.branch_id join departments on departments.branch_id = students.branch_id",nativeQuery = true)
    List<StudentBranchProjection> findAllTables();


}
