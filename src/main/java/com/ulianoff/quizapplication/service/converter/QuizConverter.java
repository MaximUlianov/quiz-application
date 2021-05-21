package com.ulianoff.quizapplication.service.converter;

import com.ulianoff.quizapplication.model.domain.Quiz;
import com.ulianoff.quizapplication.model.dto.quiz.QuizDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuizConverter {

    QuizDto quizToQuizDto(Quiz quiz);

    Quiz quizDtoToQuiz(QuizDto quizDto);
}
