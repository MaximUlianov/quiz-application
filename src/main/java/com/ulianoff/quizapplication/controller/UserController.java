package com.ulianoff.quizapplication.controller;

import com.ulianoff.quizapplication.facade.UserFacade;
import com.ulianoff.quizapplication.model.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserFacade userFacade;

    @GetMapping
    public List<UserDto> getAllUsers() {
        log.info(">>> get all users");
        return userFacade.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") String id) {
        log.info(">>> requesting user by id: {}", id);
        return userFacade.getUserById(id);
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        log.info(">>> creating user with username: {}", userDto.getUsername());
        return userFacade.createUser(userDto);
    }
}
