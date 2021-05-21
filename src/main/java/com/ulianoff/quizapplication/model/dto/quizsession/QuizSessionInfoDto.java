package com.ulianoff.quizapplication.model.dto.quizsession;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuizSessionInfoDto {

    private String id;

    private String quizId;

    private String quizTitle;

    private List<UserQuizStatusDto> usersStatus;
}
