package com.ulianoff.quizapplication.controller;

import com.ulianoff.quizapplication.model.dto.UserDto;
import com.ulianoff.quizapplication.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers() {

        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") String id) {

        return userService.getById(id);
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {

        log.info(">>> creating user with username: {}", userDto.getUsername());
        return userService.createUser(userDto);
    }

    @PostMapping("/admin")
    public UserDto createAdminUser(@RequestBody UserDto userDto) {

        log.info(">>> creating admin with username: {}", userDto.getUsername());
        return userService.createAdminUser(userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {

        userService.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
