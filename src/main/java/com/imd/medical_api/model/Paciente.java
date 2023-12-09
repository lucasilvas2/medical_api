package com.imd.medical_api.model;

import com.imd.medical_api.domain.paciente.PacienteCreateDTO;
import com.imd.medical_api.domain.paciente.PacienteUpdateDTO;
import com.imd.medical_api.enun.Genero;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
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

    public  Paciente(PacienteCreateDTO pacienteCreateDTO, User user){
        this.DataNascimento = pacienteCreateDTO.DataNascimento();
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String DataNascimento;
    @OneToOne
    private User user;

    public void update(PacienteUpdateDTO pacienteUpdateDTO, User user){

        if(pacienteUpdateDTO.DataNascimento() != null){
            this.DataNascimento = pacienteUpdateDTO.DataNascimento();
        }

        if(user != null){
            this.user = user;
        }

    }

}
