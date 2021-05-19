package com.ulianoff.quizapplication.controller;

import com.ulianoff.quizapplication.model.dto.RoleDto;
import com.ulianoff.quizapplication.service.role.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/roles")
@RequiredArgsConstructor
@Slf4j
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<Void> createRole(@RequestBody @Valid RoleDto roleDto) {

        roleService.createRole(roleDto);

        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{id}")
    public RoleDto getRoleById(@PathVariable("id") String id) {

        return roleService.getRoleById(id);
    }
}
