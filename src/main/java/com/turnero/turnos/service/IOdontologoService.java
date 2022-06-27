package com.turnero.turnos.service;


import com.turnero.turnos.entity.OdontologoDTO;

import java.util.Set;

public interface IOdontologoService {
    void guardarOdontologo(OdontologoDTO odontologoDTO);
    OdontologoDTO getOdontologo(Long id);
    void eliminarOdontologo(Long id);
    void actualizarOdontologo(OdontologoDTO odontologoDTO);
    Set<OdontologoDTO> listarTodos();
}
