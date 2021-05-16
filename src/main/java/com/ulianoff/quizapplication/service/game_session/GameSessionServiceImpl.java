package com.ulianoff.quizapplication.service.game_session;

import com.ulianoff.quizapplication.dao.GameSessionRepository;
import com.ulianoff.quizapplication.model.domain.GameSession;
import com.ulianoff.quizapplication.model.domain.Quiz;
import com.ulianoff.quizapplication.model.domain.Room;
import com.ulianoff.quizapplication.model.dto.GameSessionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GameSessionServiceImpl implements GameSessionService {

    private final GameSessionRepository repository;

    @Override
    public GameSessionDto save(GameSessionDto dto) {

        GameSession gameSession = new GameSession();

        Quiz quiz = new Quiz();
        quiz.setId(Long.parseLong(dto.getQuizId()));
        gameSession.setQuiz(quiz);

        Room room = new Room();
        room.setId(Long.parseLong(dto.getRoomId()));
        gameSession.setRoom(room);

        repository.save(gameSession);
        dto.setId(gameSession.getId().toString());

        return dto;
    }

    @Override
    public GameSessionDto startGameSession(String gameSessionId) {

        GameSession gameSession = repository.findById(Long.parseLong(gameSessionId)).orElseThrow();

        LocalDateTime now = LocalDateTime.now();
        gameSession.setStartTimestamp(now);
        repository.save(gameSession);

        GameSessionDto gameSessionDto = new GameSessionDto();
        gameSessionDto.setId(gameSessionId);
        gameSessionDto.setStartTimestamp(now.toString());

        return gameSessionDto;
    }

    @Override
    public GameSessionDto completeGameSession(String gameSessionId) {

        GameSession gameSession = repository.findById(Long.parseLong(gameSessionId)).orElseThrow();

        LocalDateTime now = LocalDateTime.now();
        gameSession.setEndTimestamp(now);
        repository.save(gameSession);

        GameSessionDto gameSessionDto = new GameSessionDto();
        gameSessionDto.setId(gameSessionId);
        gameSessionDto.setEndTimestamp(now.toString());

        return gameSessionDto;
    }

    @Override
    public GameSessionDto getById(String id) {
        return null;
    }

    @Override
    public List<GameSessionDto> getAll() {
        return null;
    }

    @Override
    public boolean delete(GameSessionDto entity) {
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }
}
