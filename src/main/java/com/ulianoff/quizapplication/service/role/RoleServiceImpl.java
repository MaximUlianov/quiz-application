package com.ulianoff.quizapplication.service.role;

import com.ulianoff.quizapplication.dao.RoleRepository;
import com.ulianoff.quizapplication.model.domain.Role;
import com.ulianoff.quizapplication.model.dto.RoleDto;
import com.ulianoff.quizapplication.model.enums.RoleEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    @Override
    @Transactional
    public RoleDto createRole(RoleDto dto) {

        for (RoleEnum roleName : RoleEnum.values()) {
            Role role = new Role();
            role.setName(roleName.toString());
            repository.save(role);
        }

        return dto;
    }

    @Override
    public RoleDto getRoleById(String id) {

        Role role = repository.findById(Long.parseLong(id)).orElseThrow();

        return RoleDto.builder()
                .id(id)
                .role(RoleEnum.valueOf(role.getName()))
                .build();
    }
}
