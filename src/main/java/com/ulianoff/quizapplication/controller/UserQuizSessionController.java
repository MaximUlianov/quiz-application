package com.ulianoff.quizapplication.controller;

import com.ulianoff.quizapplication.model.dto.quizsession.usersession.UserQuizSessionDto;
import com.ulianoff.quizapplication.service.userquizsession.UserQuizSessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/user-quiz-sessions")
@RequiredArgsConstructor
@Slf4j
public class UserQuizSessionController {

    private final UserQuizSessionService userQuizSessionService;

    @PostMapping("/start")
    public ResponseEntity<Void> startSession(@RequestBody @Valid UserQuizSessionDto dto) {

        userQuizSessionService.startSession(dto);

        return ResponseEntity.accepted().build();
    }

    @PostMapping("/end")
    public ResponseEntity<Void> endSession(@RequestBody @Valid UserQuizSessionDto dto) {

        userQuizSessionService.endSession(dto);

        return ResponseEntity.accepted().build();
    }
}
