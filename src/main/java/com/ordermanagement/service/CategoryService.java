package com.ordermanagement.service;

import com.ordermanagement.dto.CategoryReq;
import com.ordermanagement.models.Category;
import com.ordermanagement.repository.CategoryRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public Category save(CategoryReq category){
        Category category1 = new Category();
        BeanUtils.copyProperties(category,category1);
        return categoryRepo.save(category1);
    }
}
