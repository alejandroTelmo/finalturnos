package com.turnero.turnos.service;


import com.turnero.turnos.entity.OdontologoDTO;
import com.turnero.turnos.exception.ResourceNotFoundException;

import java.util.Optional;
import java.util.Set;

public interface IOdontologoService {
    void guardarOdontologo(OdontologoDTO odontologoDTO);
    Optional<OdontologoDTO> buscarOdontologo(Long id) throws ResourceNotFoundException;
    void eliminarOdontologo(Long id) throws ResourceNotFoundException;
    void actualizarOdontologo(OdontologoDTO odontologoDTO) throws ResourceNotFoundException;
    Set<OdontologoDTO> listarTodos() throws ResourceNotFoundException;
    Optional<OdontologoDTO> buscarOdontologoPorApellido(String apellido) throws ResourceNotFoundException;
}
