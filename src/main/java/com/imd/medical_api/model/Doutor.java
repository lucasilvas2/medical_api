package com.imd.medical_api.model;

import com.imd.medical_api.domain.doutor.DoutorCreateDTO;
import com.imd.medical_api.domain.doutor.DoutorUpdateDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "doutor")
@Entity(name = "Doutor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doutor {

    public Doutor(DoutorCreateDTO doutorCreateDTO){
        this.nome = doutorCreateDTO.nome();
        this.especialidade = doutorCreateDTO.especialidade();
        this.idade = doutorCreateDTO.idade();
        this.email = doutorCreateDTO.email();
        this.ativo = doutorCreateDTO.ativo();
    }
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nome;
    @NotNull
    private String especialidade;
    private Integer idade;
    @Email
    private String email;
    @Column(columnDefinition = "boolean default true")
    private Boolean ativo;

    public void update(DoutorUpdateDTO doutorUpdateDTO){
        if(doutorUpdateDTO.nome() != null){
            this.nome = doutorUpdateDTO.nome();
        }
        if(doutorUpdateDTO.especialidade() != null){
            this.especialidade = doutorUpdateDTO.especialidade();
        }
        if( doutorUpdateDTO.idade() != null){
            this.idade = doutorUpdateDTO.idade();
        }
        if( doutorUpdateDTO.email() != null){
            this.email = doutorUpdateDTO.email();
        }
        if (doutorUpdateDTO.ativo() != null) {
            this.ativo = doutorUpdateDTO.ativo();
        }
    }
}
