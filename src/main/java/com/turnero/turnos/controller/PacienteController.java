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
@CrossOrigin(origins = "http://localhost:63342")
public class PacienteController {
    IPacienteService pacienteService;


    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> guardar(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.guardarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDTO  buscarPaciente(@PathVariable Long id){
        return    pacienteService.buscarPaciente(id);
    }

    @GetMapping
    public List<PacienteDTO> listarPacientes(){
        return pacienteService.listarTodos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> actualizarPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.actualizarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus>eliminar(@PathVariable Long id){
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/buscar/{nombre}")
    public Optional<PacienteDTO> buscarPacientePorNombre(@PathVariable("nombre")  String nombre){
        return    pacienteService.buscarPorNombre(nombre);
    }

}
