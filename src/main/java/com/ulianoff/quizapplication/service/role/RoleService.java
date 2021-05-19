package com.ulianoff.quizapplication.service.role;

import com.ulianoff.quizapplication.model.dto.RoleDto;

public interface RoleService {

    RoleDto createRole(RoleDto dto);

    RoleDto getRoleById(String id);
}
