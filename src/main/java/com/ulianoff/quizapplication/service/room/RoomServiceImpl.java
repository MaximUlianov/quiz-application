package com.ulianoff.quizapplication.service.room;

import com.ulianoff.quizapplication.dao.RoomRepository;
import com.ulianoff.quizapplication.model.domain.Room;
import com.ulianoff.quizapplication.model.domain.User;
import com.ulianoff.quizapplication.model.dto.RoomDto;
import com.ulianoff.quizapplication.service.converter.RoomConverter;
import com.ulianoff.quizapplication.util.RandomUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    private final RoomConverter converter;

    @Override
    public RoomDto createRoom(RoomDto roomDto) {

        Room room = converter.roomDtoToRoom(roomDto);
        room.setUsers(new HashSet<>());
        room.setCode(RandomUtil.generateRandomCode());

        roomRepository.save(room);

        roomDto.setId(String.valueOf(room.getId()));
        roomDto.setCode(room.getCode());

        return roomDto;
    }

    @Override
    public List<RoomDto> getAllRooms() {
        return roomRepository.findAll()
                .stream()
                .map(converter::roomToRoomDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRoomById(String id) {

        roomRepository.deleteById(Long.parseLong(id));
    }

    @Override
    public RoomDto getRoomByCode(String code) {

        return converter.roomToRoomDto(roomRepository.findByCode(code).orElseThrow());
    }

    @Override
    public RoomDto addUserToRoom(RoomDto roomDto) {

        Room room;
        if (roomDto.getId() != null) {
            room = roomRepository.findById(Long.parseLong(roomDto.getId())).orElseThrow();
        } else {
            room = roomRepository.findByCode(roomDto.getCode()).orElseThrow();
        }

        User user = new User();
        user.setId(Long.parseLong(roomDto.getUserId()));

        room.getUsers().add(user);

        roomRepository.save(room);
        return roomDto;
    }
}
