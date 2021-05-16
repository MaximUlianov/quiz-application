package com.ulianoff.quizapplication.facade;


import com.ulianoff.quizapplication.model.dto.QuizDto;

public interface QuizFacade {
    QuizDto addQuiz(QuizDto quizDto);

    QuizDto getQuizById(String id);
}
