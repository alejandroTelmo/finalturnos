package com.turnero.turnos.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.turnero.turnos.entity.Paciente;
import com.turnero.turnos.entity.PacienteDTO;
import com.turnero.turnos.repository.IPacienteRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PacienteService implements IPacienteService{

    private final IPacienteRepository pacienteRepository;
    private final Logger logger=Logger.getLogger(PacienteService.class);

    public PacienteService(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }
    @Autowired
    ObjectMapper mapper;

    @Override
    public void guardarPaciente(PacienteDTO pacienteDTO) {
        pacienteRepository.save(mapper.convertValue(pacienteDTO, Paciente.class));
        logger.info("Nuevo paciente creado con exito.");
    }
    @Override
    public PacienteDTO buscarPaciente(Long id) {

        return mapper.convertValue(pacienteRepository.findById(id),PacienteDTO.class);
    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
        logger.info("Paciente con id "+id+" eliminado con exito.");
    }

    @Override
    public void actualizarPaciente(PacienteDTO pacienteDTO) {
        //la validacion del if la hago para  cerciorarme que tenga id y que exista el id de pacientedto
            if(pacienteDTO.getId()!=null && pacienteDTO.getId()==pacienteRepository.findById(pacienteDTO.getId()).get().getId()){
                pacienteRepository.save(mapper.convertValue(pacienteDTO,Paciente.class));
                logger.info("Paciente con id "+pacienteDTO.getId()+" actualizado con exito.");
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
    @Override
    public Optional<PacienteDTO> buscarPorNombre(String nombre){

        PacienteDTO paciente= mapper.convertValue(pacienteRepository.buscarPorNombre(nombre),PacienteDTO.class) ;
        Optional<PacienteDTO> optionalPacienteDTO=Optional.ofNullable(paciente);
        return optionalPacienteDTO;
    }
}
