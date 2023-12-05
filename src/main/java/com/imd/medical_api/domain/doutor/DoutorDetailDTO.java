package com.imd.medical_api.domain.doutor;

import com.imd.medical_api.model.Doutor;
import com.imd.medical_api.model.User;

public record DoutorDetailDTO(
        Long id,
        String nome,
        String especialidade,
        Integer idade,
        String email,
        Boolean ativo
) {
    public DoutorDetailDTO(Doutor doutor) {
        this(doutor.getId(), doutor.getNome(), doutor.getEspecialidade(), doutor.getIdade(), doutor.getEmail(),  doutor.getAtivo());
    }
}
