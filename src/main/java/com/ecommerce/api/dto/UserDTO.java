package com.ecommerce.api.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class UserDTO {
    private Long id;
    @Size(min = 3, max = 50, message = "Nome deve ter entre 3 e 50 caracteres")
    @NotBlank(message = "Nome é obrigatório")
    private String name;
    @NotBlank(message = "Nome é obrigatório")
    @Email(message = "Email deve ser válido")
    private String email;
    @Size(min = 8, message = "Senha deve ter ao menos 8 caracteres")
    private String password;
    @Pattern(regexp = "\\+?[0-9]{10,15}", message = "Telefone deve ser válido")
    private String phone;
    @Past(message = "A data de nascimento deve ser no passado")
    private LocalDate birthDate;
    @NotBlank(message = "Função é obrigatória")
    @Pattern(regexp = "ADMIN|USER|MANAGER", message = "Role inválido")
    private String roles;
}
