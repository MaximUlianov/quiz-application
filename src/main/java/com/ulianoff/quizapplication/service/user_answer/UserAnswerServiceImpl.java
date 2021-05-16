package com.ulianoff.quizapplication.service.user_answer;

import com.ulianoff.quizapplication.dao.UserAnswerRepository;
import com.ulianoff.quizapplication.model.domain.*;
import com.ulianoff.quizapplication.model.dto.UserAnswerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserAnswerServiceImpl implements UserAnswerService {

    private final UserAnswerRepository repository;

    @Override
    public UserAnswerDto save(UserAnswerDto dto) {

        UserAnswer userAnswer = new UserAnswer();

        User user = new User();
        user.setId(Long.parseLong(dto.getUserId()));
        userAnswer.setUser(user);

        GameSession gameSession = new GameSession();
        gameSession.setId(Long.parseLong(dto.getGameSessionId()));
        userAnswer.setGameSession(gameSession);

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

    @Override
    public UserAnswerDto getById(String id) {
        return null;
    }

    @Override
    public List<UserAnswerDto> getAll() {
        return null;
    }

    @Override
    public boolean delete(UserAnswerDto entity) {
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }
}
