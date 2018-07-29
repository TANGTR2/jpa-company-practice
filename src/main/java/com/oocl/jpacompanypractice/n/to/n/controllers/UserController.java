package com.oocl.jpacompanypractice.n.to.n.controllers;

import com.oocl.jpacompanypractice.n.to.n.entities.User;
import com.oocl.jpacompanypractice.n.to.n.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    private UserRepository userRepository;

    @Autowired
    public Controller(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping(path = "/users")
    public User save(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping(path = "/users")
    public List<User> getAll(){
        return userRepository.findAll();
    }
}
