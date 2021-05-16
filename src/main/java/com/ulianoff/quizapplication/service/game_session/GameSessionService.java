package com.ulianoff.quizapplication.service.game_session;

import com.ulianoff.quizapplication.model.dto.GameSessionDto;
import com.ulianoff.quizapplication.service.common.CommonService;

public interface GameSessionService extends CommonService<GameSessionDto> {

    GameSessionDto startGameSession(String gameSessionId);

    GameSessionDto completeGameSession(String gameSessionId);
}
