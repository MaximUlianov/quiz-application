package com.ulianoff.quizapplication.model.dto.quizsession;

import lombok.Data;

@Data
public class UserAnswerDto {

    private String id;

    private String userQuizSessionId;

    private String quizSessionId;

    private String quizId;

    private String questionId;

    private String answerId;
}
