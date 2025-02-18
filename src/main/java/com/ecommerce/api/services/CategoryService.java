package com.ecommerce.api.services;

import com.ecommerce.api.dto.CategoryDTO;
import com.ecommerce.api.entities.Category;
import com.ecommerce.api.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> getAllCategories() {
        List<Category> result = categoryRepository.findAll();
        List<CategoryDTO> list = result.stream().map(x->new CategoryDTO(x).toList());
        return list;
    }
}
