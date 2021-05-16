package com.ulianoff.quizapplication.dao;

import com.ulianoff.quizapplication.model.domain.Quiz;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuizRepository extends CrudRepository<Quiz, Long> {

    List<Quiz> findAll();
}
