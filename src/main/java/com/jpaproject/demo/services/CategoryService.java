package com.jpaproject.demo.services;

import com.jpaproject.demo.model.Category;
import com.jpaproject.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.transform.impl.InterceptFieldEnabled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Integer id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.get();
    }
}
