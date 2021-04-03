package com.ulianoff.quizapplication.controller;

import com.ulianoff.quizapplication.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserFacade userFacade;

    @GetMapping("/get")
    public ResponseEntity<?> getRequest() {
        //userService.addUser();
        log.debug("user added");
        return ResponseEntity.ok("added");
    }

}
