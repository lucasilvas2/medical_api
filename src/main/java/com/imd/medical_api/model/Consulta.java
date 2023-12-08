package com.imd.medical_api.model;


import com.imd.medical_api.domain.consulta.ConsultaCreateDTO;
import com.imd.medical_api.domain.consulta.ConsultaUpdateDTO;
import com.imd.medical_api.enun.Status;
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

    public Consulta(ConsultaCreateDTO consutalCreateDTO, Doutor doutor, Paciente paciente){
        this.paciente = paciente;
        this.doutor = doutor;
        this.dataConsulta = consutalCreateDTO.dataConsulta();
        this.diagnostico = consutalCreateDTO.diagnostico();
        this.status = consutalCreateDTO.status();
        this.ativo = consutalCreateDTO.ativo();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Paciente paciente;
    @ManyToOne
    private Doutor doutor;
    private String dataConsulta;
    private String diagnostico;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Boolean ativo;

    public void update(ConsultaUpdateDTO consultaUpdateDTO, Doutor doutor, Paciente paciente){
        if(consultaUpdateDTO.dataConsulta() != null){
            this.dataConsulta = consultaUpdateDTO.dataConsulta();
        }
        if(consultaUpdateDTO.diagnostico() != null){
            this.diagnostico = consultaUpdateDTO.diagnostico();
        }
        if( consultaUpdateDTO.status() != null){
            this.status = consultaUpdateDTO.status();
        }
        if( consultaUpdateDTO.status() != null){
            this.status = consultaUpdateDTO.status();
        }
        if( doutor != null){
            this.doutor = doutor;
        }
        if ( paciente!= null) {
            this.paciente = paciente ;
        }
    }
}
