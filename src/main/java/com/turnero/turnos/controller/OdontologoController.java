package com.turnero.turnos.controller;


import com.turnero.turnos.entity.OdontologoDTO;
import com.turnero.turnos.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping("/odontologos")
@RestController
public class OdontologoController {
    @Autowired
    private IOdontologoService odontologoService;

    @CrossOrigin(origins = "http://localhost:63342")
    @ResponseBody
    @PostMapping
    public ResponseEntity<?> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        odontologoService.guardarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @ResponseBody
    @GetMapping("/{id}")
    public OdontologoDTO buscarOdontologo(@PathVariable Long id) {

        return odontologoService.getOdontologo(id);
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @ResponseBody
    @GetMapping
    public Set<OdontologoDTO> listarOdontologos() {

        return odontologoService.listarTodos();
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @ResponseBody
    @PutMapping
    public ResponseEntity<?> actualizarOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        odontologoService.actualizarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
