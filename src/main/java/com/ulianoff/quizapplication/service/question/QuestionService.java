package com.ulianoff.quizapplication.service.question;

import com.ulianoff.quizapplication.model.dto.quiz.QuestionDto;

public interface QuestionService {

    QuestionDto createQuestion(QuestionDto questionDto);
}
