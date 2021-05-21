package com.ulianoff.quizapplication.model.dto.quizsession;

import lombok.Data;

@Data
public class QuizSessionCreationDto {

    private String id;

    private String roomId;

    private String creatorId;

    private String quizId;
}
