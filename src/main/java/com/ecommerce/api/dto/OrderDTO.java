package com.ecommerce.api.dto;

import com.ecommerce.api.entities.OrderStatus;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;

    @NotNull(message = "O momento da ordem é obrigatório")
    @PastOrPresent(message = "A data do pedido não pode ser no futuro")
    private Instant moment;

    @NotNull(message = "O status da ordem é obrigatório")
    @Pattern(regexp = "WAITING_PAYMENT|PAID|SHIPPED|DELIVERED|CANCELED", message = "Status inválido")
    private OrderStatus status;

    @NotNull(message = "O usuário é obrigatório")
    private UserDTO user;

    @NotNull(message = "O pagamento é obrigatório")
    private PaymentDTO payment;

    @NotEmpty(message = "É obrigatório adicionar ao menos um item no pedido")
    private List<OrderItemDTO> orderItems;
}
