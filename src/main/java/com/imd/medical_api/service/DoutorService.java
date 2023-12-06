package com.imd.medical_api.service;

import com.imd.medical_api.domain.doutor.DoutorCreateDTO;
import com.imd.medical_api.model.Doutor;
import com.imd.medical_api.repository.DoutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class DoutorService {
    @Autowired
    DoutorRepository repository;

    //Cadastrar um novo doutor na tabela
    public ResponseEntity cadastrarDoutor(DoutorCreateDTO dados){
        repository.save(new Doutor(dados));
        return ResponseEntity.noContent().build();
    }
}
