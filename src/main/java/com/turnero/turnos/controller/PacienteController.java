package com.turnero.turnos.controller;

import com.turnero.turnos.entity.PacienteDTO;
import com.turnero.turnos.service.IPacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    IPacienteService pacienteService;

    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.guardarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/{id}")
    public PacienteDTO  buscarPaciente(@PathVariable Long id){

        return    pacienteService.getPaciente(id);

    }
    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping
    public List<PacienteDTO> listarPacientes(){
        return pacienteService.listarTodos();
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @PutMapping
    public ResponseEntity<?> actualizarPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.actualizarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @DeleteMapping("/{id}")
    public ResponseEntity<?>eliminar(@PathVariable Long id){
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
