package com.ecommerce.api.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String phone;
    private LocalDate birthDate;
    private String roles;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    public User(Object name, Object password, Object email, Object phone, Object roles) {
        this.name = (String) name;
        this.password = (String) password;
        this.email = (String) email;
        this.phone = (String) phone;
        this.roles = (String) roles;
    }
}
