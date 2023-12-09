package com.imd.medical_api.domain.user;

import com.imd.medical_api.enun.Genero;
import com.imd.medical_api.model.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record UserDetailDTO(
        Long id,
        String nome,
        String telefone,
        String email,
        Boolean ativo,
        @Enumerated(EnumType.STRING)
        Genero genero
) {
    public UserDetailDTO(User user) {
        this(user.getId(), user.getNome(), user.getTelefone(), user.getEmail(), user.getAtivo(), user.getGenero());
    }
}
