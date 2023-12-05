package com.imd.medical_api.model;

import jakarta.persistence.*;
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

    public Doutor(Doutor dados){
        this.nome = dados.nome;
        this.especialidade = dados.especialidade;
        this.idade = dados.idade;
        this.email = dados.email;
        this.ativo = true;

    }
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String especialidade;
    private int idade;
    private String email;
    private boolean ativo;
}
