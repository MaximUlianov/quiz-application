package com.ulianoff.quizapplication.facade.impl;

import com.ulianoff.quizapplication.facade.RoomFacade;
import com.ulianoff.quizapplication.model.dto.RoomDto;
import com.ulianoff.quizapplication.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomFacadeImpl implements RoomFacade {

    private final RoomService roomService;

    @Override
    @Transactional
    public RoomDto getRoomByCode(String code) {

        return roomService.getRoomByCode(code);
    }

    @Override
    public List<RoomDto> getAllRooms() {
        return null;
    }

    @Override
    @Transactional
    public RoomDto createRoom(RoomDto roomDto) {

        roomService.add(roomDto);

        return addUserToRoom(roomDto);
    }

    @Override
    public RoomDto addUserToRoom(RoomDto roomDto) {

        roomService.addUserToRoom(roomDto);

        return roomDto;
    }

    @Override
    public RoomDto addQuizToRoom(RoomDto roomDto) {

        return roomService.addQuizToRoom(roomDto);
    }
}
