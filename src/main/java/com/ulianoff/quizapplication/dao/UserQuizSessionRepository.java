package com.ulianoff.quizapplication.dao;

import com.ulianoff.quizapplication.model.domain.UserQuizSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserQuizSessionRepository extends CrudRepository<UserQuizSession, Long> {

    Optional<List<UserQuizSession>> findAllByQuizSession_Id(Long id);
}
