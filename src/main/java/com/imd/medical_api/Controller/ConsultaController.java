package com.imd.medical_api.Controller;

import com.imd.medical_api.domain.consulta.ConsultaCreateDTO;
import com.imd.medical_api.domain.consulta.ConsultaDetailDTO;
import com.imd.medical_api.domain.consulta.ConsultaUpdateDTO;
import com.imd.medical_api.model.Consulta;
import com.imd.medical_api.service.ConsultaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = {"/consultas"})
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @GetMapping
    public List<Consulta> findAll(){
        return consultaService.findAll();
    }

    @GetMapping(value="/{id}")
    public Consulta findById(@PathVariable Long id){
        return consultaService.findById(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid ConsultaCreateDTO consultaCreateDTO, UriComponentsBuilder uriComponentsBuilder){
        var consulta = consultaService.create(consultaCreateDTO);
        var uri = uriComponentsBuilder.path("/consultas/{id}").buildAndExpand(consulta.getId()).toUri();
        return  ResponseEntity.created(uri).body(new ConsultaDetailDTO(consulta));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid ConsultaUpdateDTO consultaUpdateDTO){
        var consulta = consultaService.update(consultaUpdateDTO);
        return ResponseEntity.ok(new ConsultaDetailDTO(consulta));
    }

    @DeleteMapping(value="/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        consultaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
