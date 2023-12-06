package com.imd.medical_api.domain.consulta;

import com.imd.medical_api.model.Consulta;
import com.imd.medical_api.model.Doutor;
import com.imd.medical_api.model.Paciente;
import com.imd.medical_api.enun.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record ConsultaDetailDTO(
        Long id,
        String dataConsulta,
        String diagnostico,
        @Enumerated(EnumType.STRING)
        Status status,
        Boolean ativo,
        Doutor doutor,
        Paciente paciente
) {
        public ConsultaDetailDTO(Consulta consulta){
                this(consulta.getId(), consulta.getDataConsulta(), consulta.getDiagnostico(), consulta.getStatus(), consulta.getAtivo(), consulta.getDoutor(), consulta.getPaciente());
        }
}
