package com.ulianoff.quizapplication.controller;

import com.ulianoff.quizapplication.facade.CategoryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/categories")
public class CategoryController {

    private final CategoryFacade categoryFacade;
}
