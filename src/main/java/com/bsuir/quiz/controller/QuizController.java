package com.bsuir.quiz.controller;

import com.bsuir.quiz.dto.QuizDto;
import com.bsuir.quiz.facade.QuizFacade;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("apiv1/quiz")
public class QuizController {

    private static Logger LOGGER = LogManager.getLogger(QuizController.class);

    private QuizFacade quizFacade;

    @Autowired
    public QuizController(QuizFacade quizFacade) {
        this.quizFacade = quizFacade;
    }

    @GetMapping
    public ResponseEntity<?> getQuiz(@RequestParam("id") String id) {
        LOGGER.log(Level.INFO, "get Quiz by id{" + id + "}");
        return ResponseEntity.ok(quizFacade.getQuizById(Long.parseLong(id)));
    }

    @PostMapping(value = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createQuiz(@RequestBody QuizDto quizDto) {
        quizFacade.addQuiz(quizDto);
        return ResponseEntity.ok("Created");
    }

}
