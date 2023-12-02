package com.contact.manager.controller;


import com.contact.manager.Model.UserModel;
import com.contact.manager.entities.User;
import com.contact.manager.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;


    @PostMapping("/register")
    ResponseEntity<User> registerUser(@RequestBody UserModel userModel){
        return new ResponseEntity<>(userService.createUser(userModel), HttpStatus.CREATED);
    }
}
