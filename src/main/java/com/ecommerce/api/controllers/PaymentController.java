package com.ecommerce.api.controllers;

import com.ecommerce.api.dto.PaymentDTO;
import com.ecommerce.api.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping ("/{id}")
    public ResponseEntity <PaymentDTO> findById (Long id) {
        PaymentDTO payment = paymentService.findById(id);
        return ResponseEntity.ok(payment);
    }

    @GetMapping
    public ResponseEntity <List<PaymentDTO>> findAll (){
        List<PaymentDTO> dtos = paymentService.findAll();
        return ResponseEntity.ok(dtos);
    }
    @PostMapping
    public ResponseEntity <PaymentDTO> createPayment (PaymentDTO dto) {
        PaymentDTO createdPayment = paymentService.createPayment(dto);
        return ResponseEntity.ok(createdPayment);
    }
    @PutMapping ("/id")
    public ResponseEntity <PaymentDTO> updatePayment (Long id, PaymentDTO dto) {
        PaymentDTO updatedPayment = paymentService.updatePayment(id, dto);
        return ResponseEntity.ok(updatedPayment);
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity <Void> delete (Long id) {
        paymentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
