package com.keshav.ekart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.keshav.ekart.model.User;
import com.keshav.ekart.services.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("")
public class UserController {
    
    @Autowired
    UserService service;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = service.getAllUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<User> userOptional = service.getUserById(id);

        return userOptional.map(ResponseEntity::ok)
                           .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping("/adduser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = service.addUser(user);
        System.out.println("User is created");
        return new ResponseEntity<>(newUser,HttpStatus.CREATED);
    }

    @PutMapping("users/{id}/update")
    public ResponseEntity<User> updateUserDetails(@PathVariable Long id, @RequestBody User user) {
        if(service.getUserById(id) == null)
            return ResponseEntity.notFound().build();

        User updatedUser = service.updateUserDetails(id,user);        
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("users/delete/{id}")
    public String deleteUserbyId(@PathVariable Long id){
        if(!service.getUserById(id).isPresent())
            return "User with Id "+ id + " is not avaialble";

        service.deleteUserbyId(id);
        return "User with id "+ id +" Deleted";
    }
    
}
