package com.ulianoff.quizapplication.dao;

import com.ulianoff.quizapplication.model.domain.UserAnswer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAnswerRepository extends CrudRepository<UserAnswer, Long> {

    List<UserAnswer> findAllByQuizSession_Id(Long id);

    List<UserAnswer> findAllByUserQuizSession_Id(Long id);
}
