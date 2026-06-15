package com.yanmaia12.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;
    private String password;

    public User() {
    }

    public User(String nome, String email, String password) {
        this.nome = nome;
        this.email = email;
        this.password = password;
    }
}
