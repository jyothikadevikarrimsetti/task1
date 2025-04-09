package com.example.task1.controller;

import com.example.task1.model.Customer;
import com.example.task1.model.UserEntity;
import com.example.task1.service.UserSrevice;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
//@Controller
public class CustomerController {
    @Autowired
    UserSrevice userSrevice;
    @GetMapping("/customer")
    public Customer getCustomer(@RequestParam  String name , String location) {

        Customer customer = new Customer(name,location);

        return customer;

    }
//    @GetMapping("/user")
//        public ResponseEntity<String> getUsers(@RequestParam("name") String name){
//
//        List<UserEntity> userEntities =
//    }
    @PostMapping("/{id}/post")
    public ResponseEntity<UserEntity> getPostComment(@PathVariable String id,@RequestBody UserEntity user ){
        user.setPost(id);
        userSrevice.postUser(user);
        return ResponseEntity.ok(userSrevice.getUser(user.getName()));

    }
//    @GetMapping("/users/{id}")
//    public ResponseEntity<User> getUser(@PathVariable String id){
//
//    }




//    @RequestMapping("/name")
//       String getHello(){
//        return "hello";
//    }
}
