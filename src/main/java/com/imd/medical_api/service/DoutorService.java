package com.imd.medical_api.service;

import com.imd.medical_api.domain.doutor.DoutorCreateDTO;
import com.imd.medical_api.domain.doutor.DoutorDetailDTO;
import com.imd.medical_api.domain.doutor.DoutorUpdateDTO;
import com.imd.medical_api.model.Doutor;
import com.imd.medical_api.model.Paciente;
import com.imd.medical_api.repository.DoutorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoutorService {
    @Autowired
    DoutorRepository repository;
    @Autowired
    UserService userService;

    //Cadastrar um novo doutor na tabela
    public ResponseEntity cadastrarDoutor(DoutorCreateDTO dados){
        var user = userService.create(dados.userCreateDTO());
        repository.save(new Doutor(dados, user));
        return ResponseEntity.noContent().build();
    }


    public List<Doutor> listarDoutores(){
        return repository.findAll();
    }

    public Doutor buscaDoutorId(Long id){
        return repository.findById(id).isPresent() ? repository.findById(id).get() : null;
    }

    @Transactional
    public ResponseEntity deleteDoutor(Long id){
        if(id == null){
            return ResponseEntity.badRequest().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    public ResponseEntity atualizarDoutor(DoutorUpdateDTO dados){
        if(dados.id() == null){
            return ResponseEntity.badRequest().build();
        }
        Doutor doutor = repository.getReferenceById(dados.id());
        var user = userService.update(dados.userUpdateDTO());
        doutor.update(dados, user);
        return ResponseEntity.ok().build();
    }

    public Doutor findById(Long id){
        return repository.findById(id).isPresent() ? repository.findById(id).get() : null;
    }
}
