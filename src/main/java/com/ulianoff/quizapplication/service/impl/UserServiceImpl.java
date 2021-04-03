package com.ulianoff.quizapplication.service.impl;

import com.ulianoff.quizapplication.model.domain.User;
import com.ulianoff.quizapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Override
    public User addEntity(User user) {
        return null;
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
