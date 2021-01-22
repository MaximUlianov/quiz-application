package com.bsuir.quiz.controller;

import com.bsuir.quiz.facade.UserFacade;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apiv1/user")
public class UserController {

    private static Logger LOGGER = LogManager.getLogger(UserController.class);

    private UserFacade userFacade;

    @Autowired
    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getRequest() {
        //userService.addUser();
        LOGGER.log(Level.INFO, "user added");
        return ResponseEntity.ok("added");
    }

}
