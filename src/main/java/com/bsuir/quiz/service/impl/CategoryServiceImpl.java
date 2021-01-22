package com.bsuir.quiz.service.impl;

import com.bsuir.quiz.dao.Repository;
import com.bsuir.quiz.model.Category;
import com.bsuir.quiz.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private Repository<Category> repository;

    @Autowired
    public CategoryServiceImpl(@Qualifier("categoryDao") Repository<Category> repository) {
        this.repository = repository;
    }

    @Override
    public Category addEntity(Category entity) {
        return null;
    }

    @Override
    public Category getEntityById(Long id) {
        return null;
    }

    @Override
    public List<Category> getAllEntities() {
        return null;
    }

    @Override
    public boolean deleteEntity(Category category) {
        return false;
    }

    @Override
    public boolean deleteEntityById(Long id) {
        return false;
    }
}
