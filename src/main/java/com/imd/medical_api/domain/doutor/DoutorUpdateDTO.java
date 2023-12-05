package com.imd.medical_api.domain.doutor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DoutorUpdateDTO(
        @NotNull
        Long id,
        @NotNull
        String nome,
        String especialidade,
        Integer idade,
        @Email
        String email,
        Boolean ativo
) {
}
