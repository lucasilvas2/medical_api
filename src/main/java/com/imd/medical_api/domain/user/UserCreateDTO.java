package com.imd.medical_api.domain.user;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserCreateDTO(
        @NotNull
        String nome,
        String telefone,
        @Email
        String email,
        Boolean ativo
) {
}
