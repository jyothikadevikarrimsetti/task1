package com.example.task1.repository;

import com.example.task1.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepo extends JpaRepository<Faculty , Integer> {
}
