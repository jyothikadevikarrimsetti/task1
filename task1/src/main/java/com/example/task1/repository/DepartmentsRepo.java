package com.example.task1.repository;

import com.example.task1.model.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentsRepo extends JpaRepository<Departments , Integer> {
}
