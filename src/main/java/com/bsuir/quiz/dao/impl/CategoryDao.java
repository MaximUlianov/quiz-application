package com.bsuir.quiz.dao.impl;

import com.bsuir.quiz.dao.AbstractHibernateDao;
import com.bsuir.quiz.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao extends AbstractHibernateDao<Category> {
    public CategoryDao() {
        setClazz(Category.class);
    }
}
