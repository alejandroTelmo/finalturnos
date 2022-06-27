package com.turnero.turnos.service;

import com.turnero.turnos.entity.DomicilioDTO;


import java.util.List;


public interface IDomicilioService {
    void guardarDomicilio(DomicilioDTO domicilioDTO);
    DomicilioDTO buscarDomicilio(Long id);
    void eliminarDomicilio(Long id);
    void actualizarDomicilio(DomicilioDTO domicilioDTO);
    List<DomicilioDTO> listarTodos();
}
