package com.ulianoff.quizapplication.facade.impl;

import com.ulianoff.quizapplication.facade.QuizFacade;
import com.ulianoff.quizapplication.model.dto.quiz.AnswerDto;
import com.ulianoff.quizapplication.model.dto.quiz.QuestionDto;
import com.ulianoff.quizapplication.model.dto.quiz.QuizDto;
import com.ulianoff.quizapplication.service.answer.AnswerService;
import com.ulianoff.quizapplication.service.question.QuestionService;
import com.ulianoff.quizapplication.service.quiz.QuizService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
        quizService.createQuiz(quizDto);

        questions.forEach(question -> {
            Set<AnswerDto> answers = question.getAnswers();
            question.setQuizId(quizDto.getId());
            questionService.createQuestion(question);

            answers.forEach(answer -> {
                answer.setQuestionId(question.getId());
                answerService.createAnswer(answer);
            });
        });
        return quizDto;
    }

    @Override
    public QuizDto getQuizById(String id) {

        return quizService.getQuizById(id);
    }

    @Override
    public List<QuizDto> getAllQuiz(String creatorId) {

        if (StringUtils.isNotBlank(creatorId)) {

        }
        return null;
    }
}
