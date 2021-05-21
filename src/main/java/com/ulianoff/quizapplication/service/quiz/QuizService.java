package com.ulianoff.quizapplication.service.quiz;

import com.ulianoff.quizapplication.model.dto.quiz.QuizDto;

import java.util.List;

public interface QuizService {

    QuizDto createQuiz(QuizDto quizDto);

    QuizDto getQuizById(String id);

    List<QuizDto> getAllQuiz();

    List<QuizDto> getAllQuizByCreatorId(String creatorId);
}
