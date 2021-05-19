package com.ulianoff.quizapplication.service.auth;

import com.ulianoff.quizapplication.model.dto.AuthDto;

public interface AuthService {

    AuthDto getAuthInfoByUsername(String username);
}
