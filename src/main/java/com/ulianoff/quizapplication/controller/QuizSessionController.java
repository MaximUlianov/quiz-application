package com.ulianoff.quizapplication.controller;

import com.ulianoff.quizapplication.model.dto.quizsession.QuizSessionCreationDto;
import com.ulianoff.quizapplication.model.dto.quizsession.JoinQuizSessionDto;
import com.ulianoff.quizapplication.model.dto.quizsession.QuizSessionInfoDto;
import com.ulianoff.quizapplication.model.dto.quizsession.usersession.UserQuizDto;
import com.ulianoff.quizapplication.service.quizsession.QuizSessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/quiz-sessions")
@RequiredArgsConstructor
@Slf4j
public class QuizSessionController {

    private final QuizSessionService service;

    @GetMapping("/{id}")
    public QuizSessionInfoDto getQuizSessionInfoById(@PathVariable("id") String id) {

        log.debug(">>> requesting game with code: {}", id);
        return service.getQuizSessionInfoById(id);
    }

    @PostMapping
    public QuizSessionInfoDto createQuizSession(@Valid @RequestBody QuizSessionCreationDto quizSessionCreationDto) {

        return service.createQuizSession(quizSessionCreationDto);
    }

    @PatchMapping("/complete/{sessionId}")
    public ResponseEntity<Void> completeQuizSession(@PathVariable(name = "sessionId") String sessionId) {

        service.completeGameSession(sessionId);

        return ResponseEntity.accepted().build();
    }

    @PatchMapping("/join")
    public UserQuizDto joinQuizSession(@RequestBody @Valid JoinQuizSessionDto dto) {

        return service.joinUserToQuizSession(dto);
    }
}
