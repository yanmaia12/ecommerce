package com.yanmaia12.ecommerce.dto;

import com.yanmaia12.ecommerce.enums.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.util.List;

public record ProductDTO(@NotBlank String name,
                         @NotNull @Positive BigDecimal price,
                         @NotNull Category category,
                         @NotNull @PositiveOrZero Integer stock,
                         List<String> urls) {
}
