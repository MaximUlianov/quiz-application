package com.ulianoff.quizapplication.model.dto;

import com.ulianoff.quizapplication.model.enums.RoleEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleDto {

    private String id;

    private RoleEnum role;
}
