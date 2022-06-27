package com.turnero.turnos.service;


import com.turnero.turnos.entity.PacienteDTO;

import java.util.List;
import java.util.Set;

public interface IPacienteService {
    void guardarPaciente(PacienteDTO pacienteDTO);
    PacienteDTO getPaciente(Long id);
    void eliminarPaciente(Long id);
    void actualizarPaciente(PacienteDTO pacienteDTO);
    List<PacienteDTO> listarTodos();
}