package com.ulianoff.quizapplication.service;

import com.ulianoff.quizapplication.model.dto.RoomDto;

public interface RoomService extends CommonService<RoomDto> {

    RoomDto getRoomByCode(String code);

    RoomDto addUserToRoom(RoomDto roomDto);

    RoomDto addQuizToRoom(RoomDto roomDto);
}
