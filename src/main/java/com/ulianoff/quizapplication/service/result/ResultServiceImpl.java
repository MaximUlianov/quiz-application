package com.ulianoff.quizapplication.service.result;

import com.ulianoff.quizapplication.dao.UserAnswerRepository;
import com.ulianoff.quizapplication.model.domain.UserAnswer;
import com.ulianoff.quizapplication.model.dto.ResultDto;
import com.ulianoff.quizapplication.service.result.calculator.PointsCalculator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ResultServiceImpl implements ResultService {

    private final UserAnswerRepository userAnswerRepository;

    private final PointsCalculator pointsCalculator;

    @Override
    public List<ResultDto> getAllGameSessionResults(String gameSessionId) {

        List<UserAnswer> userAnswers = userAnswerRepository.findAllByGameSession_Id(Long.parseLong(gameSessionId));

        return pointsCalculator.calculatePoints(userAnswers).entrySet().stream()
                .map(it -> new ResultDto(it.getKey(), it.getValue()))
                .collect(Collectors.toList());
    }
}
