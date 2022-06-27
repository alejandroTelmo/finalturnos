package com.turnero.turnos.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.turnero.turnos.entity.Usuario;
import com.turnero.turnos.entity.UsuarioDTO;
import com.turnero.turnos.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService implements IUsuarioService{

    IUsuarioRepository usuarioRepository;

    public UsuarioService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    @Autowired
    ObjectMapper mapper;

    @Override
    public void guardarUsuario(UsuarioDTO usuarioDTO) {
        usuarioRepository.save(mapper.convertValue(usuarioDTO, Usuario.class));

    }

    @Override
    public UsuarioDTO getUsuario(Long id) {

        return mapper.convertValue(usuarioRepository.findById(id),UsuarioDTO.class);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public void actualizarUsuario(UsuarioDTO usuarioDTO) {
        if (usuarioDTO.getId()!=null)
            usuarioRepository.save(mapper.convertValue(usuarioDTO, Usuario.class));
    }

    @Override
    public List<UsuarioDTO> listarTodos() {
        List<Usuario> usuarios=usuarioRepository.findAll();
        List<UsuarioDTO> usuarioDTOS=new ArrayList<>();
        for (Usuario u:usuarios){
            usuarioDTOS.add(mapper.convertValue(u,UsuarioDTO.class));
        }
        return usuarioDTOS;
    }
}
