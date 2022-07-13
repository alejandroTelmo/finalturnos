package com.turnero.turnos.service;


import com.turnero.turnos.entity.Paciente;
import com.turnero.turnos.entity.PacienteDTO;
import com.turnero.turnos.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IPacienteService {
    void guardarPaciente(PacienteDTO pacienteDTO);
    PacienteDTO buscarPaciente(Long id) throws ResourceNotFoundException;
    void eliminarPaciente(Long id) throws ResourceNotFoundException;
    void actualizarPaciente(PacienteDTO pacienteDTO) throws ResourceNotFoundException;
    List<PacienteDTO> listarTodos();
    Optional<PacienteDTO> buscarPorNombre(String name) throws ResourceNotFoundException;
}
