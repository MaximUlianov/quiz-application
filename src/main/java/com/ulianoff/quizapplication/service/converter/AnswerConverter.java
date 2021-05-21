package com.ulianoff.quizapplication.service.converter;

import com.ulianoff.quizapplication.model.domain.Answer;
import com.ulianoff.quizapplication.model.dto.quiz.AnswerDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {QuizConverter.class})
public interface AnswerConverter {

    AnswerDto answerToAnswerDto(Answer answer);

    Answer answerDtoToAnswer(AnswerDto answerDto);
}
