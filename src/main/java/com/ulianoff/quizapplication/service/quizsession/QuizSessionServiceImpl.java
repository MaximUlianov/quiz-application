package com.ulianoff.quizapplication.service.quizsession;

import com.ulianoff.quizapplication.dao.QuizSessionRepository;
import com.ulianoff.quizapplication.model.domain.Quiz;
import com.ulianoff.quizapplication.model.domain.QuizSession;
import com.ulianoff.quizapplication.model.domain.Room;
import com.ulianoff.quizapplication.model.domain.User;
import com.ulianoff.quizapplication.model.dto.quiz.QuizDto;
import com.ulianoff.quizapplication.model.dto.quizsession.JoinQuizSessionDto;
import com.ulianoff.quizapplication.model.dto.quizsession.QuizSessionCreationDto;
import com.ulianoff.quizapplication.model.dto.quizsession.QuizSessionInfoDto;
import com.ulianoff.quizapplication.model.dto.quizsession.UserQuizStatusDto;
import com.ulianoff.quizapplication.model.dto.quizsession.usersession.UserQuizDto;
import com.ulianoff.quizapplication.model.dto.quizsession.usersession.UserQuizSessionDto;
import com.ulianoff.quizapplication.service.converter.QuizConverter;
import com.ulianoff.quizapplication.service.result.ResultService;
import com.ulianoff.quizapplication.service.userquizsession.UserQuizSessionService;
import com.ulianoff.quizapplication.util.RandomUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class QuizSessionServiceImpl implements QuizSessionService {

    private final QuizSessionRepository repository;

    private final UserQuizSessionService userQuizSessionService;

    private final QuizConverter quizConverter;

    private final ResultService resultService;

    @Override
    public QuizSessionInfoDto createQuizSession(QuizSessionCreationDto dto) {

        QuizSession quizSession = new QuizSession();
        quizSession.setStartTimestamp(LocalDateTime.now());
        quizSession.setCode(RandomUtil.generateRandomCode());

        Quiz quiz = new Quiz();
        quiz.setId(Long.parseLong(dto.getQuizId()));
        quizSession.setQuiz(quiz);

        Room room = new Room();
        room.setId(Long.parseLong(dto.getRoomId()));
        quizSession.setRoom(room);

        User user = new User();
        user.setId(Long.parseLong(dto.getCreatorId()));

        repository.save(quizSession);

        return getQuizSessionInfoById(String.valueOf(quizSession.getId()));
    }

    @Override
    @Transactional
    public QuizSessionInfoDto getQuizSessionInfoById(String id) {

        QuizSession quizSession = repository.findById(Long.parseLong(id)).orElseThrow();

        Quiz quiz = quizSession.getQuiz();

        List<UserQuizStatusDto> usersStatus = userQuizSessionService.getUserSessionsByQuizSessionId(id)
                .stream()
                .map(this::createUserStatusDto)
                .collect(Collectors.toList());

        return QuizSessionInfoDto.builder()
                .quizId(String.valueOf(quiz.getId()))
                .quizTitle(quiz.getTitle())
                .usersStatus(usersStatus)
                .build();
    }

    @Override
    public void completeGameSession(String gameSessionId) {

        QuizSession quizSession = repository.findById(Long.parseLong(gameSessionId)).orElseThrow();

        LocalDateTime now = LocalDateTime.now();
        quizSession.setEndTimestamp(now);
        repository.save(quizSession);
    }

    @Override
    public UserQuizDto joinUserToQuizSession(JoinQuizSessionDto dto) {

        QuizSession quizSession = repository.findByCode(dto.getQuizSessionCode()).orElseThrow();

        QuizDto quizDto = quizConverter.quizToQuizDto(quizSession.getQuiz());

        return UserQuizDto.builder()
                .userId(dto.getUserId())
                .quizSessionId(quizSession.getId().toString())
                .quizDto(quizDto)
                .build();
    }

    private UserQuizStatusDto createUserStatusDto(UserQuizSessionDto userQuizSessionDto) {

        UserQuizStatusDto statusDto = new UserQuizStatusDto();
        statusDto.setUsername(userQuizSessionDto.getUsername());
        statusDto.setStartTimestamp(userQuizSessionDto.getStartTimestamp());

        if (StringUtils.isNotBlank(userQuizSessionDto.getEndTimestamp())) {
            statusDto.setEndTimestamp(userQuizSessionDto.getEndTimestamp());
            statusDto.setPoints(resultService.getUserResultByUserSessionId(userQuizSessionDto.getId()).getPoints());
        }

        return statusDto;
    }
}
