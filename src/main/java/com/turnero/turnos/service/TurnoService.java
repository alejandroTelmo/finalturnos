package com.turnero.turnos.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.turnero.turnos.entity.Turno;
import com.turnero.turnos.entity.TurnoDTO;
import com.turnero.turnos.exception.ResourceNotFoundException;
import com.turnero.turnos.repository.ITurnoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TurnoService implements ITurnoService{

    private final ITurnoRepository turnoRepository;
    @Autowired
    ObjectMapper mapper;
    private final Logger logger=Logger.getLogger(TurnoService.class);

    public TurnoService(ITurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    @Override
    public void guardarTurno(TurnoDTO turnoDTO) {
        logger.info("Nuevo turno creado con exito.");
        turnoRepository.save(mapper.convertValue(turnoDTO, Turno.class));
    }

    @Override
    public TurnoDTO buscarTurno(Long id) throws ResourceNotFoundException {

        return mapper.convertValue(turnoRepository.findById(id),TurnoDTO.class);
    }

    @Override
    public void eliminarTurno(Long id) throws ResourceNotFoundException{
        if (turnoRepository.findById(id).isPresent()){
            turnoRepository.deleteById(id);
            logger.info("Turno eliminado con exito.");
        }else
            throw new ResourceNotFoundException("Turno con id"+id+" no encontrado.");

    }

    @Override
    public void actualizarTurno(TurnoDTO turnoDTO) throws ResourceNotFoundException {
        if (turnoDTO.getId()!=null && turnoDTO.getId()==turnoRepository.findById(turnoDTO.getId()).get().getId()){
            turnoRepository.save(mapper.convertValue(turnoDTO, Turno.class));
            logger.info("Turno actualizado con exito.");
        }else
            throw new ResourceNotFoundException("Turno para actualizar no tiene id o no existe el id pasado.");

    }

    @Override
    public List<TurnoDTO> listarTodos() {
        List<Turno> turnos=turnoRepository.findAll();
        List<TurnoDTO> turnoDTOS=new ArrayList<>();
        for(Turno t:turnos){
            turnoDTOS.add(mapper.convertValue(t,TurnoDTO.class));
        }
        return turnoDTOS;
    }
}
