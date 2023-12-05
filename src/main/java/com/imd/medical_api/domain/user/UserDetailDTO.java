package com.imd.medical_api.domain.user;

import com.imd.medical_api.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserDetailDTO(
        Long id,
        String name,
        String phone,
        String email,
        Boolean ativo
) {
    public UserDetailDTO(User user) {
        this(user.getId(), user.getName(), user.getPhone(), user.getPhone(), user.getAtivo());
    }
}
