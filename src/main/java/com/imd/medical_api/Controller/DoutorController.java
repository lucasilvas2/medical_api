package com.imd.medical_api.Controller;

import com.imd.medical_api.domain.doutor.DoutorCreateDTO;
import com.imd.medical_api.domain.doutor.DoutorUpdateDTO;
import com.imd.medical_api.model.Doutor;
import com.imd.medical_api.model.Paciente;
import com.imd.medical_api.service.DoutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/doutor"})
public class DoutorController {

    @Autowired
    DoutorService doutor;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DoutorCreateDTO dados){
        doutor.cadastrarDoutor(dados);
    }

    @GetMapping
    public List<Doutor> listar(){
        return doutor.listarDoutores();
    }

    @GetMapping(value="/{id}")
    public Doutor findById(@PathVariable Long id){
        return doutor.buscaDoutorId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDoutor(@PathVariable Long id){
        doutor.deleteDoutor(id);
    }

    @PutMapping
    public void AtualizarDoutor(@RequestBody @Valid DoutorUpdateDTO dados){
        doutor.atualizarDoutor(dados);
    }
}
