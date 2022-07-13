package com.turnero.turnos.service;


import com.turnero.turnos.entity.UsuarioDTO;
import com.turnero.turnos.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    void guardarUsuario(UsuarioDTO usuarioDTO);
    UsuarioDTO buscarUsuario(Long id) throws ResourceNotFoundException;
    void eliminarUsuario(Long id) throws ResourceNotFoundException;
    void actualizarUsuario(UsuarioDTO usuarioDTO) throws ResourceNotFoundException;
    List<UsuarioDTO> listarTodos();

    Optional<UsuarioDTO> buscarUsuarioPorNombreUsuario(String nombre) throws ResourceNotFoundException;
}
