package com.imd.medical_api.domain.user;

import com.imd.medical_api.enun.Genero;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserCreateDTO(
        @NotNull
        String nome,
        String telefone,
        @Email
        String email,
        Boolean ativo,
        @Enumerated(EnumType.STRING)
        Genero genero
) {

}
