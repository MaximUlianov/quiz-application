package com.ulianoff.quizapplication.service.converter;

import com.ulianoff.quizapplication.model.domain.Question;
import com.ulianoff.quizapplication.model.dto.quiz.QuestionDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionConverter {

    QuestionDto questionToQuestionDto(Question question);

    Question questionDtoToQuestion(QuestionDto questionDto);
}
