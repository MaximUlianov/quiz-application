package com.ulianoff.quizapplication.dao;

import com.ulianoff.quizapplication.model.domain.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
}
