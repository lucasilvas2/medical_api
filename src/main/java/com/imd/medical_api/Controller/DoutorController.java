package com.imd.medical_api.Controller;

import com.imd.medical_api.domain.doutor.DoutorCreateDTO;
import com.imd.medical_api.service.DoutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/doutores", "doutor"})
public class DoutorController {

    @Autowired
    DoutorService doutor;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DoutorCreateDTO dados){
        doutor.cadastrarDoutor(dados);
    }
}
