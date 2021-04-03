package com.ulianoff.quizapplication.service.impl;

import com.ulianoff.quizapplication.dao.QuizRepository;
import com.ulianoff.quizapplication.model.domain.Quiz;
import com.ulianoff.quizapplication.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository repository;

    @Override
    public Quiz addEntity(Quiz quiz) {
        return repository.save(quiz);
    }

    @Override
    public Quiz getEntityById(Long id) {
        return repository.findById(id).orElse(null);
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
