package com.imd.medical_api.service;

import com.imd.medical_api.domain.consulta.ConsultaCreateDTO;
import com.imd.medical_api.domain.consulta.ConsultaUpdateDTO;
import com.imd.medical_api.model.Consulta;
import com.imd.medical_api.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private DoutorService doutorService;
    @Autowired
    private PacienteService pacienteService;

    public ConsultaService(ConsultaRepository consultaRepository,DoutorService doutorService, PacienteService pacienteService){
        this.consultaRepository = consultaRepository;
        this.doutorService = doutorService;
        this.pacienteService = pacienteService;
    }

    public List<Consulta> findAll(){
        return consultaRepository.findAll();
    }

    public Consulta findById(Long id){
        return consultaRepository.findById(id).isPresent() ? consultaRepository.findById(id).get() : null;
    }

    public Consulta create(ConsultaCreateDTO consultaCreateDTO) {
        var paciente = pacienteService.findById(consultaCreateDTO.paciente_id());
        var doutor = doutorService.findById(consultaCreateDTO.doutor_id());
        var consulta = new Consulta(consultaCreateDTO, doutor, paciente);
        return consultaRepository.save(consulta);
    }

    public Consulta update(ConsultaUpdateDTO consultaUpdateDTO) {
        var paciente = pacienteService.findById(consultaUpdateDTO.paciente_id());
        var doutor = doutorService.findById(consultaUpdateDTO.doutor_id());
        var consulta = consultaRepository.getReferenceById(consultaUpdateDTO.id());
        consulta.update(consultaUpdateDTO, doutor, paciente);
        return consulta;
    }

    public void delete(Long id){
        consultaRepository.deleteById(id);
    }
}
