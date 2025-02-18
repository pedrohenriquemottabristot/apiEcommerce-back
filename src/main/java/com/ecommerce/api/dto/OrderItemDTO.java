// OrderItemDTO.java
package com.ecommerce.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrderItemDTO {
    private Long orderId; // ID do pedido (extraído de OrderItemPK)
    private Long productId; // ID do produto (extraído de OrderItemPK)
    @NotNull(message = "A quantidade é obrigatória")
    @Positive(message = "A quantidade deve ser maior que 0")
    private Integer quantity; // Quantidade do produto no pedido

    @NotNull(message = "O preço é obrigatório")
    @Positive(message = "O preço deve ser maior que 0")
    private Double price;
}