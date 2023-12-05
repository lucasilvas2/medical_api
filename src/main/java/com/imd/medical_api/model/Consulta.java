package com.imd.medical_api.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "consulta")
@Entity(name = "Consulta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {

    public Consulta(Consulta dados){
        this.paciente = dados.paciente;
        this.doutor = dados.doutor;
        this.dataConsulta = dados.dataConsulta;
        this.diagnostico = dados.diagnostico;
        this.ativo = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Paciente paciente;
    private Doutor doutor;
    private String dataConsulta;
    private String diagnostico;
    private boolean ativo;
}
