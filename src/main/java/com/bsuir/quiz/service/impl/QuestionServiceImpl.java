package com.bsuir.quiz.service.impl;

import com.bsuir.quiz.dao.Repository;
import com.bsuir.quiz.model.Question;
import com.bsuir.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private Repository<Question> repository;

    @Autowired
    public QuestionServiceImpl(@Qualifier("questionDao") Repository<Question> repository) {
        this.repository = repository;
    }

    @Override
    public Question addEntity(Question question) {
        return repository.add(question);
    }

    @Override
    public Question getEntityById(Long id) {
        return null;
    }

    @Override
    public List<Question> getAllEntities() {
        return null;
    }

    @Override
    public boolean deleteEntity(Question question) {
        return false;
    }

    @Override
    public boolean deleteEntityById(Long id) {
        return false;
    }
}
