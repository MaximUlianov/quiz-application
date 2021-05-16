package com.ulianoff.quizapplication.dao;

import com.ulianoff.quizapplication.model.domain.GameSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameSessionRepository extends CrudRepository<GameSession, Long> {
}
