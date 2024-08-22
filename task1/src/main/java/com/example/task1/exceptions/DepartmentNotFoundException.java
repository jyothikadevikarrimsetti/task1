package com.example.task1.exceptions;

public class DepartmentNotFoundException extends RuntimeException{
    public DepartmentNotFoundException(){
        super("Department not found");
    }
}
