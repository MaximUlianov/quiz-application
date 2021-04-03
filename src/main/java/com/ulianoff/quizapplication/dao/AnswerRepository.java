package com.ulianoff.quizapplication.dao;

import com.ulianoff.quizapplication.model.domain.Answer;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
}
