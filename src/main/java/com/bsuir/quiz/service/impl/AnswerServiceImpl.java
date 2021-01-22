package com.bsuir.quiz.service.impl;

import com.bsuir.quiz.dao.Repository;
import com.bsuir.quiz.model.Answer;
import com.bsuir.quiz.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    private Repository<Answer> repository;

    @Autowired
    public AnswerServiceImpl(@Qualifier("answerDao") Repository<Answer> repository) {
        this.repository = repository;
    }

    @Override
    public Answer addEntity(Answer answer) {
        return repository.add(answer);
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
