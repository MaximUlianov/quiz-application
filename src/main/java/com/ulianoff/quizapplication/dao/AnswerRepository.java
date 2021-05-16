package com.ulianoff.quizapplication.dao;

import com.ulianoff.quizapplication.model.domain.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
}
