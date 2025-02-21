package com.ecommerce.api.controllers;

import com.ecommerce.api.dto.ProductDTO;
import com.ecommerce.api.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping ("/{id}")
    public ResponseEntity<UserDTO> findById (@PathVariable Long id) {
        UserDTO dto = userService.findById(id);
        return ResponseEntity.ok(dto);
    }
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List <UserDTO> dtoList =userService.findAll();
        return ResponseEntity.ok(dtoList);
    }
    @PostMapping
    public ResponseEntity <UserDTO> create (@RequestBody UserDTO dto){
        UserDTO createdDto = userService.create(dto);
        return ResponseEntity.ok(createdDto);
    }
    @PutMapping ("{id")
    public ResponseEntity<UserDTO> update (@PathVariable Long id, @RequestBody UserDTO dto){
        UserDTO userDto = userService.update(id, dto);
        return ResponseEntity.ok(userDto);
    }
    @DeleteMapping (value = "{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
