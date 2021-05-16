package com.ulianoff.quizapplication.facade.impl;

import com.ulianoff.quizapplication.facade.UserFacade;
import com.ulianoff.quizapplication.model.dto.UserDto;
import com.ulianoff.quizapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;

    @Override
    public List<UserDto> getAllUsers() {

        return userService.getAll();
    }

    @Override
    public UserDto getUserById(String id) {

        return userService.getById(id);
    }

    @Override
    public UserDto createUser(UserDto userDto) {

        return userService.add(userDto);
    }
}
