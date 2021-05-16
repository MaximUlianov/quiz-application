package com.ulianoff.quizapplication.controller;

import com.ulianoff.quizapplication.model.dto.GameSessionDto;
import com.ulianoff.quizapplication.service.game_session.GameSessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/game-sessions")
@RequiredArgsConstructor
@Slf4j
public class GameSessionController {

    private final GameSessionService service;

    @GetMapping("/{id}")
    public GameSessionDto getGameSessionById(@PathVariable("id") String id) {

        log.debug(">>> requesting game with code: {}", id);
        return service.getById(id);
    }

    @PostMapping
    public GameSessionDto createGameSession(@Valid @RequestBody GameSessionDto gameSessionDto) {

        return service.save(gameSessionDto);
    }

    @PatchMapping("/start/{gameId}")
    public GameSessionDto startGameSession(@PathVariable(name = "gameId") String gameId) {

        return service.startGameSession(gameId);
    }

    @PatchMapping("/complete/{gameId}")
    public GameSessionDto completeGameSession(@PathVariable(name = "gameId") String gameId) {

        return service.completeGameSession(gameId);
    }
}
