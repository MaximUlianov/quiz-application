package com.ulianoff.quizapplication.service.auth;

import com.ulianoff.quizapplication.dao.UserRepository;
import com.ulianoff.quizapplication.model.domain.User;
import com.ulianoff.quizapplication.model.dto.AuthDto;
import com.ulianoff.quizapplication.model.enums.RoleEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    public AuthDto getAuthInfoByUsername(String username) {

        User user = userRepository.findByUsername(username).orElseThrow();

        return AuthDto.builder()
                .username(username)
                .password(user.getPassword())
                .email(user.getEmail())
                .role(RoleEnum.valueOf(user.getRole().getName()))
                .build();
    }
}
