package com.ecommerce.api.dto;

import com.ecommerce.api.entities.User;
import jakarta.validation.constraints.*;

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
    @NotBlank(message = "Função é obrigatória")
    @Pattern(regexp = "ADMIN|USER|MANAGER", message = "Role inválido")
    private String roles;

    // Construtor vazio (necessário para frameworks como Jackson)
    public UserDTO() {
    }

    // Construtor com parâmetros
    public UserDTO(String name, String password, String email, String phone, String roles) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.roles = roles;
    }

    // Construtor que aceita um objeto User
    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.roles = user.getRoles();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
