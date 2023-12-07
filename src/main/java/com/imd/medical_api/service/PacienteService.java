package com.imd.medical_api.service;


import com.imd.medical_api.domain.doutor.DoutorCreateDTO;
import com.imd.medical_api.domain.doutor.DoutorUpdateDTO;
import com.imd.medical_api.domain.paciente.PacienteCreateDTO;
import com.imd.medical_api.domain.paciente.PacienteUpdateDTO;
import com.imd.medical_api.model.Doutor;
import com.imd.medical_api.model.Paciente;
import com.imd.medical_api.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    @Autowired
    PacienteRepository repository;

    public ResponseEntity cadastrarPaciente(PacienteCreateDTO dados){
        repository.save(new Paciente(dados));
        return ResponseEntity.noContent().build();
    }

    public List<Paciente> listarPaciente(){
        return repository.findAll();
    }

    @Transactional
    public ResponseEntity deletePaciente(Long id){
        if(id == null){
            return ResponseEntity.badRequest().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    public ResponseEntity atualizarPaciente(PacienteUpdateDTO dados){
        if(dados.id() == null){
            return ResponseEntity.badRequest().build();
        }
        Paciente paciente = repository.getReferenceById(dados.id());
        paciente.update(dados);
        return ResponseEntity.ok().build();
    }
}
