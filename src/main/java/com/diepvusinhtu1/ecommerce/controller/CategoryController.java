package com.diepvusinhtu1.ecommerce.controller;

import com.diepvusinhtu1.ecommerce.service.*;
import com.diepvusinhtu1.ecommerce.service.dto.*;
import com.diepvusinhtu1.ecommerce.service.mapper.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    private final CategoryMapper categoryMapper;

    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDTO>> getCategories() {
        List<CategoryDTO> body = categoryMapper.toDtoList(categoryService.listCategories());
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        if(Objects.nonNull(categoryService.readCategory(categoryDTO.getCategoryName()))) {
            return new ResponseEntity<>(categoryDTO, HttpStatus.CONFLICT);
        }
        categoryService.createCategory(categoryMapper.toEntity(categoryDTO));
        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }

    @PostMapping("/update/{categoryID}")
    public ResponseEntity<?> updateCategory(@PathVariable("categoryID") Long categoryID, @RequestBody CategoryDTO categoryDTO) {

        if(Objects.nonNull(categoryService.readCategory(categoryID))) {
            categoryService.updateCategory(categoryID, categoryMapper.toEntity(categoryDTO));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
