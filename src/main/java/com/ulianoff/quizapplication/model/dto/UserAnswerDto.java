package com.ulianoff.quizapplication.model.dto;

import lombok.Data;

@Data
public class UserAnswerDto {

    private String id;

    private String gameSessionId;

    private String userId;

    private String quizId;

    private String questionId;

    private String answerId;
}
