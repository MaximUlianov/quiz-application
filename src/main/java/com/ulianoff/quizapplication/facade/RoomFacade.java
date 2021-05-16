package com.ulianoff.quizapplication.facade;

import com.ulianoff.quizapplication.model.dto.RoomDto;

import java.util.List;

public interface RoomFacade {

    RoomDto getRoomByCode(String code);

    List<RoomDto> getAllRooms();

    RoomDto createRoom(RoomDto roomDto);

    RoomDto addUserToRoom(RoomDto roomDto);
}
