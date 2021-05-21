package com.ulianoff.quizapplication.dao;

import com.ulianoff.quizapplication.model.domain.QuizSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizSessionRepository extends CrudRepository<QuizSession, Long> {

    Optional<QuizSession> findByCode(String code);
}
