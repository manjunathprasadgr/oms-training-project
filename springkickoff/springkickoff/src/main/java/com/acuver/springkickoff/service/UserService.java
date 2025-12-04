package com.acuver.springkickoff.service;

import com.acuver.springkickoff.dto.UserDto;

import java.util.List;

public interface UserService {
    public UserDto saveUser(UserDto userDto);
    public List<UserDto> getUsers();
}
