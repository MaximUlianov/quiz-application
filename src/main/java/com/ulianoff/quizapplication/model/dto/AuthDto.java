package com.ulianoff.quizapplication.model.dto;

import com.ulianoff.quizapplication.model.enums.RoleEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthDto {

    private String username;

    private String password;

    private String email;

    private RoleEnum role;
}
