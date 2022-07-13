package com.turnero.turnos.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.turnero.turnos.entity.Paciente;
import com.turnero.turnos.entity.PacienteDTO;
import com.turnero.turnos.exception.ResourceNotFoundException;
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
    public PacienteDTO buscarPaciente(Long id) throws ResourceNotFoundException{
            if (pacienteRepository.findById(id).isPresent())
                return mapper.convertValue(pacienteRepository.findById(id),PacienteDTO.class);
            else
                throw new ResourceNotFoundException("Paciente con id "+id+" no existe.");
    }

    @Override
    public void eliminarPaciente(Long id) throws ResourceNotFoundException {
        if (pacienteRepository.findById(id).isPresent()){
            pacienteRepository.deleteById(id);
            logger.info("Paciente con id "+id+" eliminado con exito.");
        }else
            throw new ResourceNotFoundException("No existe un paciente con id "+id+" .");

    }

    @Override
    public void actualizarPaciente(PacienteDTO pacienteDTO) throws ResourceNotFoundException {
        //la validacion del if la hago para  cerciorarme que tenga id y que exista el id de pacientedto
            if(pacienteDTO.getId()!=null && pacienteDTO.getId()==pacienteRepository.findById(pacienteDTO.getId()).get().getId()){
                pacienteRepository.save(mapper.convertValue(pacienteDTO,Paciente.class));
                logger.info("Paciente con id "+pacienteDTO.getId()+" actualizado con exito.");
            }else
                throw new ResourceNotFoundException("No tiene id o no existe el id.");
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
    public Optional<PacienteDTO> buscarPorNombre(String nombre) throws ResourceNotFoundException{
        if(pacienteRepository.buscarPorNombre(nombre).isPresent()){
            PacienteDTO paciente= mapper.convertValue(pacienteRepository.buscarPorNombre(nombre),PacienteDTO.class) ;
            Optional<PacienteDTO> optionalPacienteDTO=Optional.ofNullable(paciente);
            return optionalPacienteDTO;
        }else
            throw new ResourceNotFoundException("Paciente con nombre "+nombre+" no encontrado.");

    }
}
