package com.imd.medical_api.domain.paciente;

import com.imd.medical_api.enun.Genero;
import com.imd.medical_api.model.Paciente;
import com.imd.medical_api.model.User;

public record PacienteDetailDTO(
        Long id,
        String DataNascimento,
        User user

) {
        public PacienteDetailDTO (Paciente paciente){
                this(paciente.getId(),
                        paciente.getDataNascimento(),paciente.getUser());
        }
}
