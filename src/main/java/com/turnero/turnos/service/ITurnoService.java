package com.turnero.turnos.service;



import com.turnero.turnos.entity.TurnoDTO;
import com.turnero.turnos.exception.ResourceNotFoundException;

import java.util.List;

public interface ITurnoService {
    void guardarTurno(TurnoDTO turnoDTO);
    TurnoDTO buscarTurno(Long id) throws ResourceNotFoundException;
    void eliminarTurno(Long id) throws ResourceNotFoundException;
    void actualizarTurno(TurnoDTO turnoDTO) throws ResourceNotFoundException;
    List<TurnoDTO> listarTodos();
}
