package com.turnero.turnos.controller;

import com.turnero.turnos.entity.TurnoDTO;
import com.turnero.turnos.service.ITurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private final ITurnoService turnoService;

    public TurnoController(ITurnoService turnoService) {
        this.turnoService = turnoService;
    }
    @PostMapping
    public ResponseEntity<?>guardar(@RequestBody TurnoDTO turnoDTO){
        turnoService.guardarTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<?>actualizar(@RequestBody TurnoDTO turnoDTO){
        if(turnoDTO.getId()!=null){
            turnoService.guardarTurno(turnoDTO);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        turnoService.eliminarTurno(id);

        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public TurnoDTO buscar(@PathVariable Long id){
       return turnoService.getTurno(id);
    }
    @GetMapping
    public List<TurnoDTO> buscarTodos(){
        return turnoService.listarTodos();
    }
}
