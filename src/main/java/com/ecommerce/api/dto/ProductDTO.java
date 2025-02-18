package com.ecommerce.api.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDTO {
    private Long id;
    @Size(min = 3, max = 50, message = "Nome deve ter entre 3 e 50 caracteres")
    @NotBlank(message = "Nome é obrigatório")
    private String name;
    @Size(min = 10, message = "Descrição deve ter no minímo 10 caracteres")
    @NotBlank(message = "Descrição é obrigatório")
    private String description;
    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "Preço deve ser positivo")
    private Double price;
    @NotNull(message = "Imagem é obrigatório")
    private String imgUrl;
    @NotEmpty(message = "É obrigatório selecionar pelo menos uma categoria")
    private List<CategoryDTO> categories = new ArrayList<>();
}
