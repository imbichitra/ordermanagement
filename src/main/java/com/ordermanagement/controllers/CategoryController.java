package com.ordermanagement.controllers;

import com.ordermanagement.dto.CategoryReq;
import com.ordermanagement.models.Category;
import com.ordermanagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save")
    public Category save(@RequestBody CategoryReq category){
        return categoryService.save(category);
    }
}
