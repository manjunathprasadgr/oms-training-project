package com.acuver.springkickoff.controller;

import com.acuver.springkickoff.dto.UserDto;
import com.acuver.springkickoff.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControllor {
    @Autowired
    private UserService service;

    @PostMapping("/add")
    public UserDto addUser(@RequestBody UserDto user) {
        return service.saveUser(user);
    }

    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        return service.getUsers();
    }
}
