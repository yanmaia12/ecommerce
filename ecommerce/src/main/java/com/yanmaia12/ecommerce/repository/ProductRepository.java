package com.yanmaia12.ecommerce.repository;

import com.yanmaia12.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Boolean existsByName(String name);
}
