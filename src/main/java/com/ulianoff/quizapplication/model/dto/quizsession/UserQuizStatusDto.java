package com.ulianoff.quizapplication.model.dto.quizsession;

import lombok.Data;

@Data
public class UserQuizStatusDto {

    private String id;

    private String quizSessionId;

    private String username;

    private String startTimestamp;

    private String endTimestamp;

    private Integer correctAnswers;

    private Integer points;
}
