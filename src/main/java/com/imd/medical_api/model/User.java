package com.imd.medical_api.model;

import com.imd.medical_api.domain.user.UserCreateDTO;
import com.imd.medical_api.domain.user.UserUpdateDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nome;
    private String telefone;
    @Email
    private String email;
    @Column(columnDefinition = "boolean default true")
    private Boolean ativo;

    public User(UserCreateDTO userCreateDTO) {
        this.nome = userCreateDTO.nome();
        this.telefone = userCreateDTO.telefone();
        this.email = userCreateDTO.email();
        this.ativo = userCreateDTO.ativo();
    }

    public void update(UserUpdateDTO userUpdateDTO){
        if(userUpdateDTO.nome() != null){
            this.nome = userUpdateDTO.nome();
        }
        if(userUpdateDTO.telefone() != null){
            this.telefone = userUpdateDTO.telefone();
        }
        if( userUpdateDTO.email() != null){
            this.email = userUpdateDTO.email();
        }
        if (userUpdateDTO.ativo() != null) {
            this.ativo = userUpdateDTO.ativo();
        }
    }

}