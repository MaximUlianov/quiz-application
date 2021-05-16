package com.ulianoff.quizapplication.controller;

import com.ulianoff.quizapplication.model.dto.ResultDto;
import com.ulianoff.quizapplication.service.result.ResultService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/results")
@RequiredArgsConstructor
@Slf4j
public class ResultController {

    private final ResultService service;

    @GetMapping("/all/{gameSessionId}")
    public List<ResultDto> getAllGameSessionResults(@PathVariable("gameSessionId") String gameSessionId) {

        return service.getAllGameSessionResults(gameSessionId);
    }
}
