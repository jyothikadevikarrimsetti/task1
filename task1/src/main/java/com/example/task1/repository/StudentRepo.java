package com.example.task1.repository;

import com.example.task1.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepo extends JpaRepository<Students,Integer> {
//    @Query(value = "SELECT * FROM students WHERE id = :id", nativeQuery = true)
//    Students findStudentById(@Param("id") int id);
}
