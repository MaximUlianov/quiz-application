package com.bsuir.quiz.service.impl;

import com.bsuir.quiz.dao.Repository;
import com.bsuir.quiz.model.Room;
import com.bsuir.quiz.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private Repository<Room> repository;

    @Autowired
    public RoomServiceImpl(@Qualifier("roomDao") Repository<Room> repository) {
        this.repository = repository;
    }

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
