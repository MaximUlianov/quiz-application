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
    public Category add(Category entity) {
        return null;
    }

    @Override
    public Category getById(String id) {
        return null;
    }

    @Override
    public List<Category> getAll() {
        return null;
    }

    @Override
    public boolean delete(Category category) {
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }
}
