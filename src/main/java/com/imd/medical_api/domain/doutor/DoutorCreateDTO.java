package com.imd.medical_api.domain.doutor;

import com.imd.medical_api.domain.user.UserCreateDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DoutorCreateDTO(
        @NotNull
        String especialidade,
        @NotNull
        UserCreateDTO userCreateDTO
) {
}
