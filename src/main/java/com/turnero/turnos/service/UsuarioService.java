package com.turnero.turnos.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.turnero.turnos.entity.Usuario;
import com.turnero.turnos.entity.UsuarioDTO;
import com.turnero.turnos.exception.ResourceNotFoundException;
import com.turnero.turnos.repository.IUsuarioRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService{

    IUsuarioRepository usuarioRepository;
    @Autowired
    ObjectMapper mapper;
    private final Logger logger=Logger.getLogger(UsuarioService.class);
    public UsuarioService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public void guardarUsuario(UsuarioDTO usuarioDTO) {
        usuarioRepository.save(mapper.convertValue(usuarioDTO, Usuario.class));
        logger.info("Usuario con username "+usuarioDTO.getUsername()+ " creado con exito.");
    }

    @Override
    public UsuarioDTO buscarUsuario(Long id)throws ResourceNotFoundException {
        if (usuarioRepository.findById(id).isPresent())
            return mapper.convertValue(usuarioRepository.findById(id),UsuarioDTO.class);
        else
            throw new ResourceNotFoundException("Usuario con id "+id+" no existe.");

    }

    @Override
    public void eliminarUsuario(Long id) throws ResourceNotFoundException {
        if (usuarioRepository.findById(id).isPresent()) {
            usuarioRepository.deleteById(id);
            logger.info("Usuario con id "+id+" eliminado con exito.");
        }else
            throw new ResourceNotFoundException("Usuario con id "+id+" no existe.");
    }

    @Override
    public void actualizarUsuario(UsuarioDTO usuarioDTO) throws ResourceNotFoundException{
        if (usuarioDTO.getId()!=null && usuarioDTO.getId()==usuarioRepository.findById(usuarioDTO.getId()).get().getId()){
            usuarioRepository.save(mapper.convertValue(usuarioDTO, Usuario.class));
            logger.info("Usuario con id "+usuarioDTO.getId()+" actualizado con exito.");
        }else
            throw new ResourceNotFoundException("Usuario no tiene id o no existe el id.");

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

    @Override
    public Optional<UsuarioDTO> buscarUsuarioPorNombreUsuario(String nombre) throws ResourceNotFoundException{
        if (usuarioRepository.buscarPorNombreUsuario(nombre).isPresent()){
            UsuarioDTO usuarioDTO=mapper.convertValue(usuarioRepository.buscarPorNombreUsuario(nombre),UsuarioDTO.class);
            Optional<UsuarioDTO> optionalUsuarioDTO=Optional.ofNullable(usuarioDTO);
            return optionalUsuarioDTO;
        }else
            throw new ResourceNotFoundException("Usuario con nombre de usuario "+nombre+" no encontrado.");

    }
}
