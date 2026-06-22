package com.yanmaia12.ecommerce.dto;

import com.yanmaia12.ecommerce.enums.Category;

import java.math.BigDecimal;
import java.util.List;

public record ProductResponseDTO(Long id,
                                 String name,
                                 BigDecimal price,
                                 Category category,
                                 Integer stock,
                                 List<String> urls) {
}
