package com.yanmaia12.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "ProdutoCarrinho")
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
    @Min(value = 1, message = "Quantidade tem que ser pelo menos 1")
    private Integer quantity;

    public CartItem() {
    }

    public CartItem(Product product, Cart cart, Integer quantity) {
        this.product = product;
        this.cart = cart;
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal(){
        if (product == null || product.getPrice() == null){
            return BigDecimal.ZERO;
        }
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }
}
