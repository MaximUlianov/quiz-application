package com.ulianoff.quizapplication.service.quizsession;

import com.ulianoff.quizapplication.model.dto.quizsession.JoinQuizSessionDto;
import com.ulianoff.quizapplication.model.dto.quizsession.QuizSessionCreationDto;
import com.ulianoff.quizapplication.model.dto.quizsession.QuizSessionInfoDto;
import com.ulianoff.quizapplication.model.dto.quizsession.usersession.UserQuizDto;

public interface QuizSessionService {

    void completeGameSession(String gameSessionId);

    QuizSessionInfoDto createQuizSession(QuizSessionCreationDto quizSessionCreationDto);

    QuizSessionInfoDto getQuizSessionInfoById(String id);

    UserQuizDto joinUserToQuizSession(JoinQuizSessionDto dto);
}
