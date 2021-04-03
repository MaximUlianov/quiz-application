package com.ulianoff.quizapplication.service.impl;

import com.ulianoff.quizapplication.model.domain.Room;
import com.ulianoff.quizapplication.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Override
    public Room addEntity(Room entity) {
        return null;
    }

    @Override
    public Room getEntityById(Long id) {
        return null;
    }

    @Override
    public List<Room> getAllEntities() {
        return null;
    }

    @Override
    public boolean deleteEntity(Room entity) {
        return false;
    }

    @Override
    public boolean deleteEntityById(Long id) {
        return false;
    }
}
