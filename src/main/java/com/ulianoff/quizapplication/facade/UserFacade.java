package com.ulianoff.quizapplication.facade;

import com.ulianoff.quizapplication.model.dto.UserDto;

import java.util.List;

public interface UserFacade {

    List<UserDto> getAllUsers();

    UserDto getUserById(String id);

    UserDto createUser(UserDto userDto);
}
