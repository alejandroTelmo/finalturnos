package com.turnero.turnos.controller;

import com.turnero.turnos.entity.TurnoDTO;
import com.turnero.turnos.service.ITurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
@CrossOrigin(origins = "http://localhost:63342")
public class TurnoController {
    private final ITurnoService turnoService;

    public TurnoController(ITurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus>guardar(@RequestBody TurnoDTO turnoDTO){
        turnoService.guardarTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<HttpStatus>actualizar(@RequestBody TurnoDTO turnoDTO){
        if(turnoDTO.getId()!=null){
            turnoService.guardarTurno(turnoDTO);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminar(@PathVariable Long id){
        turnoService.eliminarTurno(id);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public TurnoDTO buscar(@PathVariable Long id){
       return turnoService.buscarTurno(id);
    }

    @GetMapping
    public List<TurnoDTO> buscarTodos(){
        return turnoService.listarTodos();
    }
}
