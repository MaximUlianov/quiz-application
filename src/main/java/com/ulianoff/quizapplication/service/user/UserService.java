package com.ulianoff.quizapplication.service.user;

import com.ulianoff.quizapplication.model.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto updateUser(UserDto user);

    UserDto getUserById(String id);

    UserDto createUser(UserDto userDto);

    UserDto createAdminUser(UserDto userDto);

    void deleteUserById(String id);

    List<UserDto> getAllUsers();
}
