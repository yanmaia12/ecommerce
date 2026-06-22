package com.yanmaia12.ecommerce.service;

import com.yanmaia12.ecommerce.dto.ProductDTO;
import com.yanmaia12.ecommerce.dto.ProductResponseDTO;
import com.yanmaia12.ecommerce.exception.BusinessException;
import com.yanmaia12.ecommerce.model.Product;
import com.yanmaia12.ecommerce.repository.ProductRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public ProductResponseDTO createProduct(ProductDTO productDTO){
        if (productRepository.existsByName(productDTO.name())) throw new BusinessException("Esse produto já existe!");

        Product product = new Product();
        product.setName(productDTO.name());
        product.setPrice(productDTO.price());
        product.setCategory(productDTO.category());
        product.setStock(productDTO.stock());
        if (productDTO.urls() == null){
            product.setUrls(new ArrayList<>());
        }else product.setUrls(productDTO.urls());

        productRepository.save(product);
        return new ProductResponseDTO(product.getId(), product.getName(), product.getPrice(), product.getCategory(), product.getStock(), product.getUrls());
    }

    @Transactional
    public void deleteProduct(Long id){
        if (!productRepository.existsById(id)) throw new BusinessException("Produto não encontrado!");

        productRepository.deleteById(id);
    }
}
