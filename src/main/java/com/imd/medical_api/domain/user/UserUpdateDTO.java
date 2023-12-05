package com.imd.medical_api.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserUpdateDTO(
        @NotNull
        Long id,
        @NotNull
        String name,
        String phone,
        @Email
        String email,
        Boolean ativo
) {
}
