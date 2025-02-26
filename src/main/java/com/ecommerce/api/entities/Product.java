package com.ecommerce.api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data //getters and setters and constructor
@Entity
@Table(name = "tb_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Double price;
    private String imgUrl;

    @ManyToMany
    @JoinTable(
            name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

    public Product(@Size(min = 3, max = 50, message = "Nome deve ter entre 3 e 50 caracteres") @NotBlank(message = "Nome é obrigatório") String name, @NotNull(message = "Preço é obrigatório") @Positive(message = "Preço deve ser positivo")
    Double price, @Size(min = 10, message = "Descrição deve ter no minímo 10 caracteres") @NotBlank(message = "Descrição é obrigatório") String description, @NotNull(message = "Imagem é obrigatório") String imgUrl) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.imgUrl = imgUrl;
    }
}
