package com.ulianoff.quizapplication.facade;


import com.ulianoff.quizapplication.model.dto.quiz.QuizDto;

import java.util.List;

public interface QuizFacade {

    QuizDto addQuiz(QuizDto quizDto);

    QuizDto getQuizById(String id);

    List<QuizDto> getAllQuiz(String creatorId);
}
