package com.imd.medical_api.model;

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

    public  Paciente(Paciente dados){
        this.nome = dados.nome;
        this.genero = dados.genero;
        this.DataNascimento = dados.DataNascimento;
        this.email = dados.email;
        this.telefone = dados.telefone;
        this.ativo = true;
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

    private boolean ativo;

}
