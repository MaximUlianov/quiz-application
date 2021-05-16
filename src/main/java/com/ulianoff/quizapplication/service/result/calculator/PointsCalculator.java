package com.ulianoff.quizapplication.service.result.calculator;

import com.ulianoff.quizapplication.model.domain.UserAnswer;

import java.util.List;
import java.util.Map;

public interface PointsCalculator {

    Map<String, Integer> calculatePoints(List<UserAnswer> userAnswers);
}
