package com.turnero.turnos.controller;

import com.turnero.turnos.entity.DomicilioDTO;
import com.turnero.turnos.service.IDomicilioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    private IDomicilioService domicilioService;

    public DomicilioController(IDomicilioService domicilioService) {
        this.domicilioService = domicilioService;
    }
    @PostMapping
    public ResponseEntity<?> crearDomicilio(@RequestBody DomicilioDTO domicilioDTO){
        domicilioService.guardarDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public DomicilioDTO buscarDomicilio(@PathVariable Long id){
       return domicilioService.buscarDomicilio(id);
    }
    @GetMapping
    public List<DomicilioDTO> listarDomicilios(){
        return domicilioService.listarTodos();
    }
    @PutMapping
    public ResponseEntity<?> actualizarDomicilio(@RequestBody DomicilioDTO domicilioDTO){
        domicilioService.actualizarDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDomicilio(@PathVariable Long id){
        domicilioService.eliminarDomicilio(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
