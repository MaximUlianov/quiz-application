package com.ulianoff.quizapplication.facade.impl;

import com.ulianoff.quizapplication.facade.QuizFacade;
import com.ulianoff.quizapplication.model.domain.Answer;
import com.ulianoff.quizapplication.model.domain.Question;
import com.ulianoff.quizapplication.model.domain.Quiz;
import com.ulianoff.quizapplication.model.dto.QuizDto;
import com.ulianoff.quizapplication.service.AnswerService;
import com.ulianoff.quizapplication.service.QuestionService;
import com.ulianoff.quizapplication.service.QuizService;
import com.ulianoff.quizapplication.service.converter.QuizConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Component
@RequiredArgsConstructor
@Slf4j
public class QuizFacadeImpl implements QuizFacade {

    private final QuizService quizService;

    private final QuestionService questionService;

    private final AnswerService answerService;

    private final QuizConverter converter;

    @Override
    @Transactional
    public Long addQuiz(QuizDto quizDto) {
        Quiz quiz = converter.quizDtoToQuiz(quizDto);
        Set<Question> questions = quiz.getQuestions();
        quiz.setQuestions(null);
        quizService.addEntity(quiz);
        questions.forEach(question -> {
            Set<Answer> answers = question.getAnswers();
            question.setQuiz(quiz);
            question.setAnswers(null);
            questionService.addEntity(question);
            answers.forEach(answer -> {
                answer.setQuestion(question);
                answerService.addEntity(answer);
            });
        });
        return quiz.getId();
    }

    @Override
    @Transactional
    public QuizDto getQuizById(long id) {
        return converter.quizToQuizDto(quizService.getEntityById(id));
    }
}
