package com.turnero.turnos.controller;

import com.turnero.turnos.entity.UsuarioDTO;
import com.turnero.turnos.exception.ResourceNotFoundException;
import com.turnero.turnos.service.IUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:63342")
public class UsuarioController {
    IUsuarioService usuarioService;

    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> crearUsuario(@RequestBody UsuarioDTO usuarioDTO){
        usuarioService.guardarUsuario(usuarioDTO);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        usuarioService.guardarUsuario(usuarioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public UsuarioDTO buscarUsuario(@PathVariable Long id) throws ResourceNotFoundException {
        return usuarioService.buscarUsuario(id);
    }

    @GetMapping
    public List<UsuarioDTO> listarUsuario(){
        return usuarioService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) throws ResourceNotFoundException {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
