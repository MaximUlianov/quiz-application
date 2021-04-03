package com.ulianoff.quizapplication.facade;


import com.ulianoff.quizapplication.model.dto.QuizDto;

public interface QuizFacade {
    Long addQuiz(QuizDto quizDto);
    QuizDto getQuizById(long id);
}
