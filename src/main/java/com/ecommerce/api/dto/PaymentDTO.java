package com.ecommerce.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
public class PaymentDTO {
    private Long id;
    @NotNull(message = "Data de pagamento é obrigatório")
    private LocalDateTime moment;
}
