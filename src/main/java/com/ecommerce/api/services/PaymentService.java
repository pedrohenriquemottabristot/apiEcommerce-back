package com.ecommerce.api.services;

import com.ecommerce.api.dto.PaymentDTO;
import com.ecommerce.api.entities.Payment;
import com.ecommerce.api.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional
    public void savePayment(Payment payment) {
        paymentRepository.save(payment);
    }

    @Transactional(readOnly = true)
    public PaymentDTO findById(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado com o id: " + id));
        return new PaymentDTO(payment.getId(), payment.getMoment());
    }

    @Transactional(readOnly = true)
    public List<PaymentDTO> findAll() {
        List<Payment> payments = paymentRepository.findAll();
        List<PaymentDTO> paymentDTOS = new ArrayList<>();
        for (Payment payment : payments) {
            paymentDTOS.add(new PaymentDTO(payment.getId(), payment.getMoment()));
        }
        return paymentDTOS;
    }

    @Transactional
    public PaymentDTO createPayment(PaymentDTO dto) {
        Payment payment = new Payment(dto.getMoment());
        Payment savedPayment = paymentRepository.save(payment);
        return new PaymentDTO(savedPayment.getId(), savedPayment.getMoment());
    }

    @Transactional
    public PaymentDTO updatePayment(Long id, PaymentDTO dto) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado com o id: " + id));
        payment.setMoment(dto.getMoment());
        Payment updatedPayment = paymentRepository.save(payment);
        return new PaymentDTO(updatedPayment.getId(), updatedPayment.getMoment());
    }

    @Transactional
    public void delete(Long id) {
        if (!paymentRepository.existsById(id)) {
            throw new RuntimeException("Pagamento não encontrado com o id: " + id);
        }
        paymentRepository.deleteById(id);
    }
}
