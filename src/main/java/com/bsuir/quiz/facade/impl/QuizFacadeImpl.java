package com.bsuir.quiz.facade.impl;

import com.bsuir.quiz.converter.ModelConverter;
import com.bsuir.quiz.dto.QuizDto;
import com.bsuir.quiz.facade.QuizFacade;
import com.bsuir.quiz.model.Answer;
import com.bsuir.quiz.model.Question;
import com.bsuir.quiz.model.Quiz;
import com.bsuir.quiz.service.AnswerService;
import com.bsuir.quiz.service.QuestionService;
import com.bsuir.quiz.service.QuizService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Component
public class QuizFacadeImpl implements QuizFacade {

    private static final Logger LOGGER = LogManager.getLogger(QuizFacadeImpl.class);

    private QuizService quizService;
    private QuestionService questionService;
    private AnswerService answerService;
    private ModelConverter converter;

    @Autowired
    public QuizFacadeImpl(QuizService quizService, QuestionService questionService, AnswerService answerService, @Qualifier("quizConverterImpl") ModelConverter converter) {
        this.quizService = quizService;
        this.questionService = questionService;
        this.answerService = answerService;
        this.converter = converter;
    }


    @Override
    @Transactional
    public void addQuiz(QuizDto quizDto) {
        Quiz quiz = (Quiz) converter.convertFromDto(quizDto);
        Set<Question> questions = quiz.getQuestions();
        quiz.setQuestions(null);
        quizService.addEntity(quiz);
        questions.forEach(question -> {
            Set<Answer> answers = question.getAnswers();
            question.setAnswers(null);
            question.setQuiz(quiz);
            questionService.addEntity(question);
            answers.forEach(answer -> {
                answer.setQuestion(question);
                answerService.addEntity(answer);
            });
        });
    }

    @Override
    @Transactional
    public QuizDto getQuizById(long id) {
        return (QuizDto) converter.convertToDto(quizService.getEntityById(id));
    }
}
