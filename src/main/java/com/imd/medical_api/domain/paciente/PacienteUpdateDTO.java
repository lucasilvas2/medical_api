package com.imd.medical_api.domain.paciente;

import com.imd.medical_api.model.Genero;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record PacienteUpdateDTO(
        @NotNull
        Long id,
        @NotNull
        String nome,
        String DataNascimento,
        @Email
        String email,
        @Enumerated(EnumType.STRING)
        Genero genero,
        String telefone,

        Boolean ativo
) {
}
