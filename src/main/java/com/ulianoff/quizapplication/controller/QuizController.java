package com.ulianoff.quizapplication.controller;

import com.ulianoff.quizapplication.facade.QuizFacade;
import com.ulianoff.quizapplication.model.dto.QuizDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/quiz")
@Slf4j
public class QuizController {

    private final QuizFacade quizFacade;

    @GetMapping
    public QuizDto getQuiz(@RequestParam("id") String id) {
        log.debug(">>> get Quiz by id {}", id);
        return quizFacade.getQuizById(Long.parseLong(id));
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Long createQuiz(@RequestBody QuizDto quizDto) {
        return quizFacade.addQuiz(quizDto);
    }

}
