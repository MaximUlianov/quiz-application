package com.bsuir.quiz.controller;

import com.bsuir.quiz.facade.CategoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apiv1/category")
public class CategoryController {

    private CategoryFacade categoryFacade;

    @Autowired
    public CategoryController(CategoryFacade categoryFacade) {
        this.categoryFacade = categoryFacade;
    }
}
