package com.imd.medical_api.domain.user;

import com.imd.medical_api.enun.Genero;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserUpdateDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        @Email
        String email,
        Boolean ativo,
        @Enumerated(EnumType.STRING)
        Genero genero
) {
}
