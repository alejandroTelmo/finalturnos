package com.turnero.turnos.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.turnero.turnos.entity.Turno;
import com.turnero.turnos.entity.TurnoDTO;
import com.turnero.turnos.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TurnoService implements ITurnoService{

    private final ITurnoRepository turnoRepository;

    public TurnoService(ITurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }
    @Autowired
    ObjectMapper mapper;

    @Override
    public void guardarTurno(TurnoDTO turnoDTO) {
        turnoRepository.save(mapper.convertValue(turnoDTO, Turno.class));
    }

    @Override
    public TurnoDTO getTurno(Long id) {
        return mapper.convertValue(turnoRepository.findById(id),TurnoDTO.class);
    }

    @Override
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public void actualizarTurno(TurnoDTO turnoDTO) {
        if (turnoDTO.getId()!=null){
            turnoRepository.save(mapper.convertValue(turnoDTO, Turno.class));
        }

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
