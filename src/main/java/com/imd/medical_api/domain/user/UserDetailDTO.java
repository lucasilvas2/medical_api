package com.imd.medical_api.domain.user;

import com.imd.medical_api.model.User;

public record UserDetailDTO(
        Long id,
        String nome,
        String telefone,
        String email,
        Boolean ativo
) {
    public UserDetailDTO(User user) {
        this(user.getId(), user.getName(), user.getTelefone(), user.getEmail(), user.getAtivo());
    }
}
