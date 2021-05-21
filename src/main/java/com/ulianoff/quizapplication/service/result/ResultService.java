package com.ulianoff.quizapplication.service.result;

import com.ulianoff.quizapplication.model.dto.ResultDto;

import java.util.List;

public interface ResultService {

    List<ResultDto> getAllGameSessionResults(String gameSessionId);

    ResultDto getUserResultByUserSessionId(String userSessionId);
}
