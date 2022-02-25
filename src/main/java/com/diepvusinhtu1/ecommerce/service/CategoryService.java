package com.diepvusinhtu1.ecommerce.service;

import com.diepvusinhtu1.ecommerce.entity.*;
import com.diepvusinhtu1.ecommerce.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    public Category readCategory(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }

    public Optional<Category> readCategory(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    public void updateCategory(Long categoryID, Category newCategory) {

        Optional<Category> categoryOptional = categoryRepository.findById(categoryID);
        if(categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.setCategoryName(newCategory.getCategoryName());
            category.setDescription(newCategory.getDescription());
            category.setImageUrl(newCategory.getImageUrl());
            categoryRepository.save(category);
        }
    }

    public List<Category> findCategoriesByMenuPath(Long menuPath) {
        return categoryRepository.findByMenuPath(menuPath);
    }
}
