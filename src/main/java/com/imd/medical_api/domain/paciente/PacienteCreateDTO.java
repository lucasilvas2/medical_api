package com.imd.medical_api.domain.paciente;

import com.imd.medical_api.domain.user.UserCreateDTO;
import com.imd.medical_api.enun.Genero;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record PacienteCreateDTO(
        String DataNascimento,
        @NotNull
        UserCreateDTO userCreateDTO
) {
}
