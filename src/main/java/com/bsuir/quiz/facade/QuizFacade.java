package com.bsuir.quiz.facade;

import com.bsuir.quiz.dto.QuizDto;

public interface QuizFacade {
    void addQuiz(QuizDto quizDto);
    QuizDto getQuizById(long id);
}
