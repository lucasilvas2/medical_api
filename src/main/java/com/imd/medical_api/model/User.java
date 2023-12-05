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
    private String name;
    private String phone;
    @Email
    private String email;
    @Column(columnDefinition = "boolean default true")
    private Boolean ativo;

    public User(UserCreateDTO userCreateDTO) {
        this.name = userCreateDTO.name();
        this.phone = userCreateDTO.phone();
        this.email = userCreateDTO.email();
        this.ativo = userCreateDTO.ativo();
    }

    public void update(UserUpdateDTO userUpdateDTO){
        if(userUpdateDTO.name() != null){
            this.name = userUpdateDTO.name();
        }
        if(userUpdateDTO.phone() != null){
            this.phone = userUpdateDTO.phone();
        }
        if( userUpdateDTO.email() != null){
            this.email = userUpdateDTO.email();
        }
        if (userUpdateDTO.ativo() != null) {
            this.ativo = userUpdateDTO.ativo();
        }
    }

}