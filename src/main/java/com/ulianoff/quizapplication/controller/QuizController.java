package com.ulianoff.quizapplication.controller;

import com.ulianoff.quizapplication.facade.QuizFacade;
import com.ulianoff.quizapplication.model.dto.quiz.QuizDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/quiz")
@Slf4j
public class QuizController {

    private final QuizFacade quizFacade;

    @GetMapping("/{id}")
    public QuizDto getQuizById(@PathVariable("id") String id) {

        log.debug(">>> get Quiz by id {}", id);
        return quizFacade.getQuizById(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public QuizDto createQuiz(@RequestBody QuizDto quizDto) {

        return quizFacade.addQuiz(quizDto);
    }

    @GetMapping
    public List<QuizDto> getAllQuiz(@RequestParam(value = "creatorId", required = false) String creatorId) {

        return quizFacade.getAllQuiz(creatorId);
    }


}
