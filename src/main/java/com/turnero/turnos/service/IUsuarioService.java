package com.turnero.turnos.service;


import com.turnero.turnos.entity.UsuarioDTO;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    void guardarUsuario(UsuarioDTO usuarioDTO);
    UsuarioDTO getUsuario(Long id);
    void eliminarUsuario(Long id);
    void actualizarUsuario(UsuarioDTO usuarioDTO);
    List<UsuarioDTO> listarTodos();

    Optional<UsuarioDTO> buscarUsuarioPorNombreUsuario(String nombre);
}
