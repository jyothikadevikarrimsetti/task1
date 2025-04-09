package com.example.task1.controller;

import com.example.task1.model.UserEntity;
import com.example.task1.service.UserSrevice;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{id}")
public class UserController {
    @Autowired
    UserSrevice userSrevice;

    @GetMapping()
    public UserEntity getUser(@PathVariable String id){
        return userSrevice.getUser(id);
    }
}
