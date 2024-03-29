package com.ulianoff.quizapplication.controller;

import com.ulianoff.quizapplication.model.dto.RoomDto;
import com.ulianoff.quizapplication.service.room.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/rooms")
@RequiredArgsConstructor
@Slf4j
public class RoomController {

    private final RoomService service;

    @GetMapping("/{code}")
    public RoomDto getRoomByCode(@PathVariable("code") String code) {

        log.debug(">>> requesting room with code: {}", code);
        return service.getRoomByCode(code);
    }

    @GetMapping
    public List<RoomDto> getAllRooms() {

        return service.getAllRooms();
    }

    @PostMapping
    public RoomDto createRoom(@Valid @RequestBody RoomDto roomDto) {

        log.debug(">>> creating {} room with name {}",
                roomDto.isPrivateRoom() ? "private" : "public", roomDto.getName());
        return service.createRoom(roomDto);
    }

    @PatchMapping
    public RoomDto addUserToRoom(@RequestBody RoomDto roomDto) {

        return service.addUserToRoom(roomDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable("id") String id) {

        service.deleteRoomById(id);
        return ResponseEntity.accepted().build();
    }
}
