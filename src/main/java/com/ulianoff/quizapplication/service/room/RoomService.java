package com.ulianoff.quizapplication.service.room;

import com.ulianoff.quizapplication.model.dto.RoomDto;

import java.util.List;

public interface RoomService {

    RoomDto createRoom(RoomDto roomDto);

    List<RoomDto> getAllRooms();

    void deleteRoomById(String id);

    RoomDto getRoomByCode(String code);

    RoomDto addUserToRoom(RoomDto roomDto);
}
