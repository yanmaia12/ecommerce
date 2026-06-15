package com.yanmaia12.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carrinhos")
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems =  new ArrayList<>();

    public Cart() {
    }

    public Cart(User user) {
        this.user = user;
        this.cartItems = new ArrayList<>();
    }
}
