package com.imd.medical_api.model;


import com.imd.medical_api.domain.consulta.ConsultaCreateDTO;
import com.imd.medical_api.domain.consulta.ConsultaUpdateDTO;
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

    public Consulta(ConsultaCreateDTO consutalCreateDTO){
        this.paciente = consutalCreateDTO.paciente();
        this.doutor = consutalCreateDTO.doutor();
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

    public void update(ConsultaUpdateDTO consultaUpdateDTO){
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
        if( consultaUpdateDTO.doutor() != null){
            this.doutor = consultaUpdateDTO.doutor();
        }
        if ( consultaUpdateDTO.paciente() != null) {
            this.paciente = consultaUpdateDTO.paciente() ;
        }
    }
}
