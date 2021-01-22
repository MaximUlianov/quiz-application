package com.bsuir.quiz.dao.impl;

import com.bsuir.quiz.dao.AbstractHibernateDao;
import com.bsuir.quiz.model.Quiz;
import org.springframework.stereotype.Repository;

@Repository
public class QuizDao extends AbstractHibernateDao<Quiz> {
    public QuizDao() {
        setClazz(Quiz.class);
    }
}
