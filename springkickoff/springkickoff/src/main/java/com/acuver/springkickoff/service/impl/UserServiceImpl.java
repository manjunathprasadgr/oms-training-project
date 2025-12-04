package com.acuver.springkickoff.service.impl;

import com.acuver.springkickoff.dto.UserDto;
import com.acuver.springkickoff.repository.UserRepository;
import com.acuver.springkickoff.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;


    @Override
    public UserDto saveUser(UserDto userDto) {
       return repository.save(userDto);
    }

    @Override
    public List<UserDto> getUsers() {
        return repository.findAll();
    }
}
