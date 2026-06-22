package com.yanmaia12.ecommerce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterDTO(@NotBlank String name,
                          @Email @NotBlank String email,
                          @NotBlank String password,
                          @NotBlank String confirmPassword) {
}
