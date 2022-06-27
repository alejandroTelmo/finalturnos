package com.turnero.turnos.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.turnero.turnos.entity.Paciente;
import com.turnero.turnos.entity.PacienteDTO;
import com.turnero.turnos.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PacienteService implements IPacienteService{

    private final IPacienteRepository pacienteRepository;

    public PacienteService(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }
    @Autowired
    ObjectMapper mapper;

    @Override
    public void guardarPaciente(PacienteDTO pacienteDTO) {
        pacienteRepository.save(mapper.convertValue(pacienteDTO, Paciente.class));

    }

    @Override
    public PacienteDTO getPaciente(Long id) {

        return mapper.convertValue(pacienteRepository.findById(id),PacienteDTO.class);
    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);

    }

    @Override
    public void actualizarPaciente(PacienteDTO pacienteDTO) {
            if(pacienteDTO.getId()!=null){
                pacienteRepository.save(mapper.convertValue(pacienteDTO,Paciente.class));
            }
    }

    @Override
    public List<PacienteDTO> listarTodos() {
     List<Paciente> pacientes=pacienteRepository.findAll();
     List<PacienteDTO> pacienteDTOS=new ArrayList<>();
     for (Paciente p:pacientes){
         pacienteDTOS.add(mapper.convertValue(p,PacienteDTO.class));
     }
        return pacienteDTOS;
    }
}
