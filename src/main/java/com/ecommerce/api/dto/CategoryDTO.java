package com.ecommerce.api.dto;

import com.ecommerce.api.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDTO {
    private Long id;
    private String name;


    public CategoryDTO(String name) {
        this.name = name;
    }

    public CategoryDTO(Category x) {
    }
}
