package com.imd.medical_api.model;

import com.imd.medical_api.domain.doutor.DoutorCreateDTO;
import com.imd.medical_api.domain.doutor.DoutorUpdateDTO;
import jakarta.persistence.*;
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

    public Doutor(DoutorCreateDTO doutorCreateDTO, User user){
        this.especialidade = doutorCreateDTO.especialidade();
        this.user = user;
    }
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String especialidade;
    @NotNull
    @OneToOne
    private User user;

    public void update(DoutorUpdateDTO doutorUpdateDTO, User user){

        if(doutorUpdateDTO.especialidade() != null){
            this.especialidade = doutorUpdateDTO.especialidade();
        }
        if(user != null){
            this.user = user;
        }
    }
}
