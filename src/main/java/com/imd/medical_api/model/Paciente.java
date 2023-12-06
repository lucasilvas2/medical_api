package com.imd.medical_api.model;

import com.imd.medical_api.domain.paciente.PacienteCreateDTO;
import com.imd.medical_api.domain.paciente.PacienteUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "paciente")
@Entity(name = "Paciente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    public  Paciente(PacienteCreateDTO pacienteCreateDTO){
        this.nome = pacienteCreateDTO.nome();
        this.genero = pacienteCreateDTO.genero();
        this.DataNascimento = pacienteCreateDTO.DataNascimento();
        this.email = pacienteCreateDTO.email();
        this.telefone = pacienteCreateDTO.telefone();
        this.ativo = pacienteCreateDTO.ativo();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String DataNascimento;
    private String email;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    private String telefone;

    private Boolean ativo;

    public void update(PacienteUpdateDTO pacienteUpdateDTO){
        if(pacienteUpdateDTO.nome() != null){
            this.nome = pacienteUpdateDTO.nome();
        }
        if(pacienteUpdateDTO.DataNascimento() != null){
            this.DataNascimento = pacienteUpdateDTO.DataNascimento();
        }
        if( pacienteUpdateDTO.genero() != null){
            this.genero = pacienteUpdateDTO.genero();
        }
        if( pacienteUpdateDTO.telefone() != null){
            this.telefone = pacienteUpdateDTO.telefone();
        }
        if( pacienteUpdateDTO.email() != null){
            this.email = pacienteUpdateDTO.email();
        }
        if (pacienteUpdateDTO.ativo() != null) {
            this.ativo = pacienteUpdateDTO.ativo();
        }
    }

}
