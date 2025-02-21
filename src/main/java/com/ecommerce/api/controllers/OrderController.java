package com.ecommerce.api.controllers;

import com.ecommerce.api.dto.OrderDTO;
import com.ecommerce.api.dto.ProductDTO;
import com.ecommerce.api.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findById (@PathVariable Long id) {
        OrderDTO dto = orderService.findById(id);
        return ResponseEntity.ok(dto);
    }
    @GetMapping
    public ResponseEntity <List<OrderDTO>> findAll() {
        List<OrderDTO> dtos = orderService.findAll();
        return ResponseEntity.ok(dtos);
    }
    @PostMapping
    public ResponseEntity <OrderDTO> create (@RequestBody ProductDTO dto){
        OrderDTO createdDto = orderService.create(dto);
        return ResponseEntity.ok(createdDto);
    }
    @PutMapping
    public ResponseEntity <OrderDTO> update (@PathVariable Long id, @RequestBody OrderDTo dto){
        OrderDTO updatedDto = orderService.update(id, dto);
        return ResponseEntity.ok(updatedDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
