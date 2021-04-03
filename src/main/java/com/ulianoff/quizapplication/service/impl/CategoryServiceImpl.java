package com.ulianoff.quizapplication.service.impl;

import com.ulianoff.quizapplication.model.domain.Category;
import com.ulianoff.quizapplication.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

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
