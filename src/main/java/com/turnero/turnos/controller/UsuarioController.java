package com.turnero.turnos.controller;

import com.turnero.turnos.entity.UsuarioDTO;
import com.turnero.turnos.service.IUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    IUsuarioService usuarioService;

    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioDTO usuarioDTO){
        usuarioService.guardarUsuario(usuarioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<?> actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        usuarioService.guardarUsuario(usuarioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public UsuarioDTO buscarUsuario(@PathVariable Long id){
        return usuarioService.getUsuario(id);
    }
    @GetMapping
    public List<UsuarioDTO> listarUsuario(){
        return usuarioService.listarTodos();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
