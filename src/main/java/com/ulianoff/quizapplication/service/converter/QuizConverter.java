package com.ulianoff.quizapplication.service.converter;

import com.ulianoff.quizapplication.model.domain.Answer;
import com.ulianoff.quizapplication.model.domain.Question;
import com.ulianoff.quizapplication.model.domain.Quiz;
import com.ulianoff.quizapplication.model.dto.AnswerDto;
import com.ulianoff.quizapplication.model.dto.QuestionDto;
import com.ulianoff.quizapplication.model.dto.QuizDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuizConverter {

    QuizDto quizToQuizDto(Quiz quiz);

    Quiz quizDtoToQuiz(QuizDto quizDto);

    QuestionDto questionToQuestionDto(Question question);

    Question questionDtoToQuestion(QuestionDto questionDto);

    AnswerDto answerToAnswerDto(Answer answer);

    Answer answerDtoToAnswer(AnswerDto answerDto);
}
