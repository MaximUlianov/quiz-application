package com.ulianoff.quizapplication.service.userquizsession;

import com.ulianoff.quizapplication.model.dto.quizsession.usersession.UserQuizSessionDto;

import java.util.List;

public interface UserQuizSessionService {

    void startSession(UserQuizSessionDto dto);

    void endSession(UserQuizSessionDto dto);

    List<UserQuizSessionDto> getUserSessionsByQuizSessionId(String quizSessionId);
}
