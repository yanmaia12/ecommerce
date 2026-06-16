package com.yanmaia12.ecommerce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CadastroDTO(@Email @NotBlank String email,
                          @NotBlank String name,
                          @NotBlank String password,
                          @NotBlank String confirmPassword) {
}
