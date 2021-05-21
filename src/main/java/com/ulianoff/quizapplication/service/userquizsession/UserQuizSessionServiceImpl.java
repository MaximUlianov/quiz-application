package com.ulianoff.quizapplication.service.userquizsession;

import com.ulianoff.quizapplication.dao.UserQuizSessionRepository;
import com.ulianoff.quizapplication.model.domain.QuizSession;
import com.ulianoff.quizapplication.model.domain.User;
import com.ulianoff.quizapplication.model.domain.UserQuizSession;
import com.ulianoff.quizapplication.model.dto.quizsession.usersession.UserQuizSessionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserQuizSessionServiceImpl implements UserQuizSessionService {

    private final UserQuizSessionRepository repository;

    @Override
    public void startSession(UserQuizSessionDto dto) {

        UserQuizSession session = new UserQuizSession();

        QuizSession quizSession = new QuizSession();
        quizSession.setId(Long.parseLong(dto.getQuizSessionId()));
        session.setQuizSession(quizSession);

        User user = new User();
        user.setId(Long.parseLong(dto.getUserId()));
        session.setUser(user);

        session.setStartTimestamp(LocalDateTime.now());

        repository.save(session);
    }

    @Override
    public void endSession(UserQuizSessionDto dto) {

        UserQuizSession session = repository.findById(Long.parseLong(dto.getId())).orElseThrow();
        session.setEndTimestamp(LocalDateTime.now());
        repository.save(session);
    }

    @Override
    public List<UserQuizSessionDto> getUserSessionsByQuizSessionId(String quizSessionId) {

        return repository.findAllByQuizSession_Id(Long.parseLong(quizSessionId))
                .orElseThrow()
                .stream()
                .map(this::createDto)
                .collect(Collectors.toList());
    }

    UserQuizSessionDto createDto(UserQuizSession model) {

        return UserQuizSessionDto.builder()
                .id(String.valueOf(model.getId()))
                .userId(String.valueOf(model.getUser().getId()))
                .username(model.getUser().getUsername())
                .startTimestamp(model.getStartTimestamp().toString())
                .endTimestamp(model.getEndTimestamp().toString())
                .quizSessionId(String.valueOf(model.getQuizSession().getId()))
                .build();
    }
}
