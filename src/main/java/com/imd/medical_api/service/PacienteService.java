package com.imd.medical_api.service;


import com.imd.medical_api.domain.doutor.DoutorCreateDTO;
import com.imd.medical_api.domain.doutor.DoutorUpdateDTO;
import com.imd.medical_api.domain.paciente.PacienteCreateDTO;
import com.imd.medical_api.domain.paciente.PacienteUpdateDTO;
import com.imd.medical_api.model.Consulta;
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
    @Autowired
    UserService userService;
    public ResponseEntity cadastrarPaciente(PacienteCreateDTO dados){
        var user = userService.create(dados.userCreateDTO());
        repository.save(new Paciente(dados, user));
        return ResponseEntity.noContent().build();
    }

    public List<Paciente> listarPaciente(){
        return repository.findAll();
    }

   public Paciente buscaPacienteId(Long id){
        return repository.findById(id).isPresent() ? repository.findById(id).get() : null;
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
    public ResponseEntity atualizarPaciente(PacienteUpdateDTO pacienteUpdateDTO){
        if(pacienteUpdateDTO.id() == null){
            return ResponseEntity.badRequest().build();
        }
        Paciente paciente = repository.getReferenceById(pacienteUpdateDTO.id());
        var user = userService.update(pacienteUpdateDTO.userUpdateDTO());
        paciente.update(pacienteUpdateDTO, user);
        return ResponseEntity.ok().build();
    }

    public Paciente findById(Long id){
        return repository.findById(id).isPresent() ? repository.findById(id).get() : null;
    }
}
