package com.ecommerce.api.services;

import com.ecommerce.api.dto.ProductDTO;
import com.ecommerce.api.entities.Product;
import com.ecommerce.api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Transactional(readOnly = true)
    public ProductDTO getProductById(Long id) {
       Product product=  productRepository.findById(id).orElseThrow();

       return new ProductDTO(product.getName(), product.getPrice(), product.getDescription(), product.getImgUrl());

    }
    @Transactional(readOnly = true)
    public List<ProductDTO> getAllProducts() {
        List<Product> products=  productRepository.findAll();
        List<ProductDTO> productsDTO=  new ArrayList<ProductDTO>();
        for(Product product: products){
            productsDTO.add(new ProductDTO(product.getName(), product.getPrice(), product.getDescription(), product.getImgUrl()));
        }
        return productsDTO;


    }
    @Transactional
    public ProductDTO create(ProductDTO dto) {
        Product product=  new Product(dto.getName(), dto.getPrice(), dto.getDescription(), dto.getImgUrl());
        Product savedProduct=  productRepository.save(product);
        return new ProductDTO(savedProduct.getName(), savedProduct.getPrice(), savedProduct.getDescription(), savedProduct.getImgUrl());
    }
    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setImgUrl(dto.getImgUrl());
        Product updatedProduct = productRepository.save(product);
        return new ProductDTO(updatedProduct.getName(), updatedProduct.getPrice(),
                updatedProduct.getDescription(), updatedProduct.getImgUrl());
    }


    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
