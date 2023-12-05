package com.imd.medical_api.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserUpdateDTO(
        @NotNull
        Long id,
        @NotNull
        String nome,
        String telefone,
        @Email
        String email,
        Boolean ativo
) {
}
