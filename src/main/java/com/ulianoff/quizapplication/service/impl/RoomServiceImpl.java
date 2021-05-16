package com.ulianoff.quizapplication.service.impl;

import com.ulianoff.quizapplication.dao.RoomRepository;
import com.ulianoff.quizapplication.model.domain.Quiz;
import com.ulianoff.quizapplication.model.domain.Room;
import com.ulianoff.quizapplication.model.domain.User;
import com.ulianoff.quizapplication.model.dto.RoomDto;
import com.ulianoff.quizapplication.service.RoomService;
import com.ulianoff.quizapplication.service.converter.RoomConverter;
import com.ulianoff.quizapplication.util.RandomUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    private final RoomConverter converter;

    @Override
    public RoomDto add(RoomDto roomDto) {

        Room room = converter.roomDtoToRoom(roomDto);
        room.setUsers(new HashSet<>());
        room.setCode(RandomUtil.generateRandomCode());

        roomRepository.save(room);

        roomDto.setId(String.valueOf(room.getId()));
        roomDto.setCode(room.getCode());

        return roomDto;
    }

    @Override
    public RoomDto getById(String id) {
        return null;
    }

    @Override
    public List<RoomDto> getAll() {
        return null;
    }

    @Override
    public boolean delete(RoomDto entity) {
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
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

    @Override
    public RoomDto addQuizToRoom(RoomDto roomDto) {

        Room room = roomRepository.findByCode(roomDto.getCode()).orElseThrow();
        Quiz quiz = new Quiz();
        quiz.setId(Long.parseLong(roomDto.getQuizId()));
        room.setQuiz(quiz);

        roomRepository.save(room);

        return roomDto;
    }
}
