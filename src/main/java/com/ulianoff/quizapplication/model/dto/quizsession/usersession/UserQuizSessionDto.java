package com.ulianoff.quizapplication.model.dto.quizsession.usersession;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserQuizSessionDto {

    private String id;

    private String startTimestamp;

    private String endTimestamp;

    private String userId;

    private String username;

    private String quizSessionId;
}
