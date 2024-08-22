package com.example.task1.exceptions;

public class FacultyNotFoundException extends RuntimeException{
    public FacultyNotFoundException(){
        super("Faculty not found");
    }
}
