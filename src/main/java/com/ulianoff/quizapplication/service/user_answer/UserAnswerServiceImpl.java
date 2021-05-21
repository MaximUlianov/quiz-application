package com.ulianoff.quizapplication.service.user_answer;

import com.ulianoff.quizapplication.dao.UserAnswerRepository;
import com.ulianoff.quizapplication.model.domain.*;
import com.ulianoff.quizapplication.model.dto.quizsession.UserAnswerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserAnswerServiceImpl implements UserAnswerService {

    private final UserAnswerRepository repository;

    @Override
    public UserAnswerDto createUserAnswer(UserAnswerDto dto) {

        UserAnswer userAnswer = new UserAnswer();

        QuizSession quizSession = new QuizSession();
        quizSession.setId(Long.parseLong(dto.getQuizSessionId()));
        userAnswer.setQuizSession(quizSession);

        UserQuizSession userQuizSession = new UserQuizSession();
        userQuizSession.setId(Long.parseLong(dto.getUserQuizSessionId()));
        userAnswer.setUserQuizSession(userQuizSession);

        Quiz quiz = new Quiz();
        quiz.setId(Long.parseLong(dto.getQuizId()));
        userAnswer.setQuiz(quiz);

        Question question = new Question();
        question.setId(Long.parseLong(dto.getQuestionId()));
        userAnswer.setQuestion(question);

        Answer answer = new Answer();
        answer.setId(Long.parseLong(dto.getAnswerId()));
        userAnswer.setAnswer(answer);

        repository.save(userAnswer);
        dto.setId(userAnswer.getId().toString());

        return dto;
    }
}
