package com.imd.medical_api.Controller;


import com.imd.medical_api.domain.doutor.DoutorCreateDTO;
import com.imd.medical_api.domain.doutor.DoutorUpdateDTO;
import com.imd.medical_api.domain.paciente.PacienteCreateDTO;
import com.imd.medical_api.domain.paciente.PacienteUpdateDTO;
import com.imd.medical_api.model.Consulta;
import com.imd.medical_api.model.Doutor;
import com.imd.medical_api.model.Paciente;
import com.imd.medical_api.service.DoutorService;
import com.imd.medical_api.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/paciente"})
public class PacienteController {

    @Autowired
    PacienteService paciente;

    @PostMapping
    public void cadastrar(@RequestBody @Valid PacienteCreateDTO dados){
        paciente.cadastrarPaciente(dados);
    }

    @GetMapping
    public List<Paciente> listar(){
        return paciente.listarPaciente();
    }

    @GetMapping(value="/{id}")
    public Paciente findById(@PathVariable Long id){
        return paciente.buscaPacienteId(id);
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable Long id){
        paciente.deletePaciente(id);
    }

    @PutMapping
    public void AtualizarPacienter(@RequestBody @Valid PacienteUpdateDTO dados){
        paciente.atualizarPaciente(dados);
    }

}
