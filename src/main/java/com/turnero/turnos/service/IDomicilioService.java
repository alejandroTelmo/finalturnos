package com.turnero.turnos.service;

import com.turnero.turnos.entity.DomicilioDTO;
import com.turnero.turnos.entity.PacienteDTO;
import com.turnero.turnos.exception.ResourceNotFoundException;


import java.util.List;
import java.util.Optional;


public interface IDomicilioService {
    void guardarDomicilio(DomicilioDTO domicilioDTO);
    Optional<DomicilioDTO> buscarDomicilio(Long id) throws ResourceNotFoundException;
    void eliminarDomicilio(Long id) throws ResourceNotFoundException;
    void actualizarDomicilio(DomicilioDTO domicilioDTO) throws ResourceNotFoundException;
    Optional<List<DomicilioDTO>> listarTodos();

    Optional<DomicilioDTO> buscarPorNombre(String name);

}
