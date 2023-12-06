package com.imd.medical_api.domain.consulta;

import com.imd.medical_api.model.Doutor;
import com.imd.medical_api.model.Paciente;
import com.imd.medical_api.enun.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record ConsultaUpdateDTO(
        Long id,
        String dataConsulta,
        String diagnostico,
        @Enumerated(EnumType.STRING)
        Status status,
        Boolean ativo,
        Doutor doutor,
        Paciente paciente
) {
}
