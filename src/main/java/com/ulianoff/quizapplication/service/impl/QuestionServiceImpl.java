package com.ulianoff.quizapplication.service.impl;

import com.ulianoff.quizapplication.dao.QuestionRepository;
import com.ulianoff.quizapplication.model.domain.Question;
import com.ulianoff.quizapplication.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository repository;

    @Override
    public Question addEntity(Question question) {
        return repository.save(question);
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
