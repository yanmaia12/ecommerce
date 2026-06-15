package com.yanmaia12.ecommerce.model;

import com.yanmaia12.ecommerce.enums.Category;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "produtos")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private Category category;
    private Integer stock;
    @ElementCollection
    private List<String> urls;

    public Product() {
    }

    public Product(String name, BigDecimal price, Category category, Integer stock, List<String> urls) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.urls = urls;
    }
}
