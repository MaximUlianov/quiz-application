package com.bsuir.quiz.dao.impl;

import com.bsuir.quiz.dao.AbstractHibernateDao;
import com.bsuir.quiz.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends AbstractHibernateDao<User> {
    public UserDao() {
        setClazz(User.class);
    }
}
