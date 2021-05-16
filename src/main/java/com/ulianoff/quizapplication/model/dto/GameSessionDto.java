package com.ulianoff.quizapplication.model.dto;

import lombok.Data;

@Data
public class GameSessionDto {

    private String id;

    private String startTimestamp;

    private String endTimestamp;

    private String roomId;

    private String quizId;
}
