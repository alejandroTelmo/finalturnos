package com.turnero.turnos.service;

import com.turnero.turnos.entity.UsuarioDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class IUsuarioServiceTest {
    @Autowired
    IUsuarioService usuarioService;

    @Test
    void guardarUsuario() {
        Integer cantidadUsuarios=usuarioService.listarTodos().size();
        UsuarioDTO usuarioDTO=new UsuarioDTO();
        usuarioDTO.setUsername("chacker");
        usuarioDTO.setPassword("123aa");
        usuarioService.guardarUsuario(usuarioDTO);
        List<UsuarioDTO> usuarioDTOList=usuarioService.listarTodos();
        assertEquals(cantidadUsuarios+1,usuarioDTOList.size());

    }

    @Test
    void getUsuario() {
        UsuarioDTO usuarioDTO=new UsuarioDTO();
        usuarioDTO.setUsername("chacker");
        usuarioDTO.setPassword("123aa");
        usuarioService.guardarUsuario(usuarioDTO);
        Optional<UsuarioDTO> optionalUsuarioDTO=usuarioService.buscarUsuarioPorNombreUsuario("chacker");

        assertEquals("chacker",optionalUsuarioDTO.get().getUsername());
    }

    @Test
    void eliminarUsuario() {
        UsuarioDTO usuarioDTO=new UsuarioDTO();
        usuarioDTO.setUsername("jacko");
        usuarioDTO.setPassword("123");
        usuarioService.guardarUsuario(usuarioDTO);
        Optional<UsuarioDTO> optionalUsuarioDTO= usuarioService.buscarUsuarioPorNombreUsuario("jacko");
        usuarioService.eliminarUsuario(optionalUsuarioDTO.get().getId());

        assertEquals(null,usuarioService.getUsuario(optionalUsuarioDTO.get().getId()));

    }

    @Test
    void actualizarUsuario() {
        UsuarioDTO usuarioDTO=new UsuarioDTO();
        usuarioDTO.setUsername("actualizar");
        usuarioDTO.setPassword("123");
        usuarioService.guardarUsuario(usuarioDTO);

        Integer cantidadUsuarios=usuarioService.listarTodos().size();

        Optional<UsuarioDTO> optionalUsuarioDTO =usuarioService.buscarUsuarioPorNombreUsuario("actualizar");

        UsuarioDTO usuarioDTO1=new UsuarioDTO();
        usuarioDTO1.setId(optionalUsuarioDTO.get().getId());
        usuarioDTO1.setUsername("modificado");
        usuarioDTO1.setPassword("987");
        usuarioService.actualizarUsuario(usuarioDTO1);

        Integer cantidadUsuariosDespues=usuarioService.listarTodos().size();

        Optional<UsuarioDTO> optionalUsuarioDTO1 =usuarioService.buscarUsuarioPorNombreUsuario("modificado");

        assertEquals("modificado",optionalUsuarioDTO1.get().getUsername());
        assertEquals(optionalUsuarioDTO.get().getId(),optionalUsuarioDTO1.get().getId());
        assertEquals(cantidadUsuarios,cantidadUsuariosDespues);


    }

    @Test
    void listarTodos() {
        UsuarioDTO usuarioDTO=new UsuarioDTO();
        usuarioDTO.setUsername("listar todos");
        usuarioDTO.setPassword("123");
        usuarioService.guardarUsuario(usuarioDTO);

        Integer cantidadUsuarios=usuarioService.listarTodos().size();

        assertTrue(cantidadUsuarios>0);
    }
}