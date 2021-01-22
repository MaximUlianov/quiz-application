package com.bsuir.quiz.dao.impl;

import com.bsuir.quiz.dao.AbstractHibernateDao;
import com.bsuir.quiz.model.Answer;
import org.springframework.stereotype.Repository;

@Repository
public class AnswerDao extends AbstractHibernateDao<Answer> {
    public AnswerDao() {
        setClazz(Answer.class);
    }
}
