package com.imd.medical_api.domain.doutor;

import com.imd.medical_api.domain.user.UserUpdateDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DoutorUpdateDTO(
        @NotNull
        Long id,
        String especialidade,
        UserUpdateDTO userUpdateDTO

) {
}
