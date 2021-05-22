package com.ulianoff.quizapplication.controller;

import com.ulianoff.quizapplication.model.dto.AuthDto;
import com.ulianoff.quizapplication.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auths")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthService authService;

    @GetMapping("/{username}")
    public AuthDto getAuthByUsername(@PathVariable("username") String username) {

        return authService.getAuthInfoByUsername(username);
    }
}
