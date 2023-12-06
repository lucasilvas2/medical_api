package com.imd.medical_api.domain.paciente;

import com.imd.medical_api.model.Genero;
import com.imd.medical_api.model.Paciente;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record PacienteDetailDTO(
        Long id,
        String nome,
        String DataNascimento,
        String email,
        Genero genero,
        String telefone,
        Boolean ativo
) {
        public PacienteDetailDTO (Paciente paciente){
                this(paciente.getId(),
                        paciente.getNome(),
                        paciente.getDataNascimento(),
                        paciente.getEmail(), paciente.getGenero(),
                        paciente.getTelefone(), paciente.getAtivo());
        }
}
