package com.ulianoff.quizapplication.dao;

import com.ulianoff.quizapplication.model.domain.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
}
