package com.example.task1.exceptions;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(){
        super("Student not found");
    }
}
