package com.imd.medical_api.domain.doutor;

import com.imd.medical_api.model.Doutor;
import com.imd.medical_api.model.User;

public record DoutorDetailDTO(
        Long id,
        String especialidade,
        User user
) {
    public DoutorDetailDTO(Doutor doutor) {
        this(doutor.getId(), doutor.getEspecialidade(), doutor.getUser());
    }
}
