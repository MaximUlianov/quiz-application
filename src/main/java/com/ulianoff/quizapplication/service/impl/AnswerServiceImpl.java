package com.ulianoff.quizapplication.service.impl;

import com.ulianoff.quizapplication.dao.AnswerRepository;
import com.ulianoff.quizapplication.model.domain.Answer;
import com.ulianoff.quizapplication.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository repository;

    @Override
    public Answer addEntity(Answer answer) {
        return repository.save(answer);
    }

    @Override
    public Answer getEntityById(Long id) {
        return null;
    }

    @Override
    public List<Answer> getAllEntities() {
        return null;
    }

    @Override
    public boolean deleteEntity(Answer entity) {
        return false;
    }

    @Override
    public boolean deleteEntityById(Long id) {
        return false;
    }
}
