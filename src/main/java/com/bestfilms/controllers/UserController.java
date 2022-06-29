package com.bestfilms.controllers;

import com.bestfilms.entities.User;
import com.bestfilms.repos.UserRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser){
        return userRepo.save(newUser);
    }

    @PostMapping("/users2")
    String addNewUser(@RequestBody User newUser){
        userRepo.save(newUser);
        return "User is saved..";
    }

    @GetMapping("/users")
    List<User> getAllUsers( ){
        return userRepo.findAll();
    }

    @GetMapping("/users/{id}")
    Optional<User> getUserById(@PathVariable Long id){
        return userRepo.findById(id);
    }
}
