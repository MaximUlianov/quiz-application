package com.bsuir.quiz.dao.impl;

import com.bsuir.quiz.dao.AbstractHibernateDao;
import com.bsuir.quiz.model.Room;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDao extends AbstractHibernateDao<Room> {
    public RoomDao() {
        setClazz(Room.class);
    }
}
