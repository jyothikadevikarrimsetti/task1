package com.example.task1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BranchNotFoundException.class)
    public ResponseEntity<String> branchNotFound(BranchNotFoundException exp){
        return new ResponseEntity<>(exp.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> studentNotFound(StudentNotFoundException exp){
        return new ResponseEntity<>(exp.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(FacultyNotFoundException.class)
    public ResponseEntity<String> facultyNotFound(FacultyNotFoundException exp){
        return new ResponseEntity<>(exp.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<String> departmentNotFound(DepartmentNotFoundException exp){
        return new ResponseEntity<>(exp.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> runtimeException(RuntimeException exp){
        return new ResponseEntity<>(exp.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exception(Exception exp){
        return new ResponseEntity<>(exp.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
