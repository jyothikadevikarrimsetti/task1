package com.example.task1.service;

import com.example.task1.model.UserEntity;
import com.example.task1.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserSrevice {
    @Autowired
    UserRepo userRepo;
    public UserEntity postUser(UserEntity userEntity){
       return userRepo.save(userEntity);

    }
    public UserEntity getUser(String id){
        return userRepo.findById(id).orElse(null);
    }

}
