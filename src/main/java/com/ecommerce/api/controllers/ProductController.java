package com.ecommerce.api.controllers;

import com.ecommerce.api.dto.ProductDTO;
import com.ecommerce.api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping(value ="/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
       ProductDTO dto = productService.getProductById(id);
       return ResponseEntity.ok(dto);
    }
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
       return ResponseEntity.ok(productService.getAllProducts());
    }
//    @PreAuthorize("hasRole('Role_ADMIN'))")
    @PostMapping
    public ResponseEntity<ProductDTO> create (@RequestBody ProductDTO dto){
        ProductDTO productDTO = productService.create(dto);
        return ResponseEntity.ok(productDTO);
    }
    @PutMapping(value ="/{id}")
    public ResponseEntity<ProductDTO> update (@PathVariable Long id, @RequestBody ProductDTO dto){
        ProductDTO productDTO = productService.update(id,dto);
        return ResponseEntity.ok(productDTO);
    }
    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
