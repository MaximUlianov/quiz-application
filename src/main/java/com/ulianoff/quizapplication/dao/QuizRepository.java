package com.ulianoff.quizapplication.dao;

import com.ulianoff.quizapplication.model.domain.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, Long> {

    List<Quiz> findAll();
}
