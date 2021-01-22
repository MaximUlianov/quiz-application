package com.bsuir.quiz.dao.impl;

import com.bsuir.quiz.dao.AbstractHibernateDao;
import com.bsuir.quiz.model.Question;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionDao extends AbstractHibernateDao<Question> {
    public QuestionDao() {
        setClazz(Question.class);
    }
}
