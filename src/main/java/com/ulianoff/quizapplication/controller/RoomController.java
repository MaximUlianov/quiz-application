package com.ulianoff.quizapplication.controller;

import com.ulianoff.quizapplication.facade.RoomFacade;
import com.ulianoff.quizapplication.model.dto.RoomDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/rooms")
@RequiredArgsConstructor
@Slf4j
public class RoomController {

    private final RoomFacade roomFacade;

    @GetMapping("/{code}")
    public RoomDto getRoomByCode(@PathVariable("code") String code) {

        log.info(">>> requesting room with code: {}", code);
        return roomFacade.getRoomByCode(code);
    }

    @GetMapping
    public List<RoomDto> getAllRooms() {

        return roomFacade.getAllRooms();
    }

    @PostMapping
    public RoomDto createRoom(@Valid @RequestBody RoomDto roomDto) {

        log.info(">>> creating {} room with name {}",
                roomDto.isPrivateRoom() ? "private" : "public", roomDto.getName());
        return roomFacade.createRoom(roomDto);
    }

    @PatchMapping
    public RoomDto addUserToRoom(@RequestBody RoomDto roomDto) {

        log.info(">>> adding user with id {} to room with code {}", roomDto.getUserId(), roomDto.getCode());
        return roomFacade.addUserToRoom(roomDto);
    }

    @PatchMapping("/quiz")
    public RoomDto addQuizToRoom(@RequestBody RoomDto roomDto) {

        log.info(">>> adding quiz with id {} to room with code {}", roomDto.getQuizId(), roomDto.getCode());
        return roomFacade.addQuizToRoom(roomDto);
    }
}
