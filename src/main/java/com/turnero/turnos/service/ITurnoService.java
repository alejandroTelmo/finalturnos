package com.turnero.turnos.service;



import com.turnero.turnos.entity.TurnoDTO;

import java.util.List;

public interface ITurnoService {
    void guardarTurno(TurnoDTO turnoDTO);
    TurnoDTO buscarTurno(Long id);
    void eliminarTurno(Long id);
    void actualizarTurno(TurnoDTO turnoDTO);
    List<TurnoDTO> listarTodos();
}
