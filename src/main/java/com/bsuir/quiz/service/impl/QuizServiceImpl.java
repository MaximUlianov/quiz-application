package com.bsuir.quiz.service.impl;

import com.bsuir.quiz.dao.Repository;
import com.bsuir.quiz.model.Quiz;
import com.bsuir.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    private Repository<Quiz> repository;

    @Autowired
    public QuizServiceImpl(@Qualifier("quizDao") Repository<Quiz> repository) {
        this.repository = repository;
    }

    @Override
    public Quiz addEntity(Quiz quiz) {
        return repository.add(quiz);
    }

    @Override
    @Cacheable(value = "quizzes", key = "#id")
    public Quiz getEntityById(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<Quiz> getAllEntities() {
        return null;
    }

    @Override
    public boolean deleteEntity(Quiz entity) {
        return false;
    }

    @Override
    public boolean deleteEntityById(Long id) {
        return false;
    }
}
