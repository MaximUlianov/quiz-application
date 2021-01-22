package com.bsuir.quiz.service.impl;

import com.bsuir.quiz.dao.Repository;
import com.bsuir.quiz.model.User;
import com.bsuir.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private Repository<User> repository;

    @Autowired
    public UserServiceImpl(@Qualifier("userDao") Repository<User> repository) {
        this.repository = repository;
    }

    @Override
    public User addEntity(User user) {
        return repository.add(user);
    }

    @Override
    public User getEntityById(Long id) {
        return null;
    }

    @Override
    public List<User> getAllEntities() {
        return null;
    }

    @Override
    public boolean deleteEntity(User entity) {
        return false;
    }

    @Override
    public boolean deleteEntityById(Long id) {
        return false;
    }
}
