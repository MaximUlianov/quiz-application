package com.ulianoff.quizapplication.dao;

import com.ulianoff.quizapplication.model.domain.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

    List<Room> findAll();

    Optional<Room> findByCode(String code);
}
