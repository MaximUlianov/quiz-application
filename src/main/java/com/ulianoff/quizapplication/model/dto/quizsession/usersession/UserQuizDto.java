package com.ulianoff.quizapplication.model.dto.quizsession.usersession;

import com.ulianoff.quizapplication.model.dto.quiz.QuizDto;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UserQuizDto implements Serializable {

    String userId;

    String quizSessionId;

    QuizDto quizDto;
}
