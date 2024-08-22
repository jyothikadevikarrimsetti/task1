package com.example.task1.exceptions;

public class BranchNotFoundException extends RuntimeException {
    public BranchNotFoundException(){
        super("Branch not found");
    }
}
