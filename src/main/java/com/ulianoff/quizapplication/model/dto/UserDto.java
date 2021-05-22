package com.ulianoff.quizapplication.model.dto;

import com.ulianoff.quizapplication.model.enums.RoleEnum;
import lombok.Data;

@Data
public class UserDto {

    private String id;

    private String username;

    private String password;

    private String email;
}
