package com.ulianoff.quizapplication.facade.impl;

import com.ulianoff.quizapplication.facade.QuizFacade;
import com.ulianoff.quizapplication.model.dto.AnswerDto;
import com.ulianoff.quizapplication.model.dto.QuestionDto;
import com.ulianoff.quizapplication.model.dto.QuizDto;
import com.ulianoff.quizapplication.service.AnswerService;
import com.ulianoff.quizapplication.service.QuestionService;
import com.ulianoff.quizapplication.service.QuizService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuizFacadeImpl implements QuizFacade {

    private final QuizService quizService;

    private final QuestionService questionService;

    private final AnswerService answerService;

    @Override
    @Transactional
    public QuizDto addQuiz(QuizDto quizDto) {

        Set<QuestionDto> questions = quizDto.getQuestions();
        quizService.add(quizDto);

        questions.forEach(question -> {
            Set<AnswerDto> answers = question.getAnswers();
            question.setQuizId(quizDto.getId());
            questionService.add(question);

            answers.forEach(answer -> {
                answer.setQuestionId(question.getId());
                answerService.add(answer);
            });
        });
        return quizDto;
    }

    @Override
    @Transactional
    public QuizDto getQuizById(String id) {

        return quizService.getById(id);
    }
}
