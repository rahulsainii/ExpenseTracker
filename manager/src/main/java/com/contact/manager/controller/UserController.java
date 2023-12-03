package com.contact.manager.controller;


import com.contact.manager.Model.UserModel;
import com.contact.manager.entities.User;
import com.contact.manager.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;


    @PostMapping("/register")
    ResponseEntity<User> registerUser(@Valid @RequestBody UserModel userModel){
        return new ResponseEntity<>(userService.createUser(userModel), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    List<User> getAllUsers(){
      return userService.getAllUsers();
    }


    @GetMapping("/user/{id}")
    User getUserById(@PathVariable("id") Long userId){
        return userService.getUserById(userId);
    }
}
