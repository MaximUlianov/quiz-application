package com.ulianoff.quizapplication.service.result.calculator;

import com.ulianoff.quizapplication.model.domain.UserAnswer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PointsCalculatorImpl implements PointsCalculator {

    @Value("${quiz.correct-answer.points}")
    private Integer correctAnswerPoints;

    @Override
    public Map<String, Integer> calculatePoints(List<UserAnswer> userAnswers) {

        Map<String, Integer> results = new HashMap<>();
        userAnswers.forEach(it -> {
            String username = it.getUser().getUsername();

            if (!results.containsKey(username)) {
                results.put(username, 0);
            }

            if (it.getAnswer().isCorrect()) {
                Integer points = results.get(username);
                points = points + correctAnswerPoints;
                results.put(username, points);
            }
        });

        return results;
    }
}
