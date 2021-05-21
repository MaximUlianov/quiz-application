package com.ulianoff.quizapplication.controller;

import com.ulianoff.quizapplication.model.dto.quizsession.UserAnswerDto;
import com.ulianoff.quizapplication.service.user_answer.UserAnswerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/user-answers")
@RequiredArgsConstructor
@Slf4j
public class UserAnswerController {

    private final UserAnswerService service;

    @PostMapping
    public ResponseEntity<Void> saveAnswer(@Valid @RequestBody UserAnswerDto userAnswerDto) {

        service.createUserAnswer(userAnswerDto);
        return ResponseEntity.accepted().build();
    }
}
