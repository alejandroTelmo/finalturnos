package com.turnero.turnos.controller;

import com.turnero.turnos.entity.DomicilioDTO;
import com.turnero.turnos.exception.ResourceNotFoundException;
import com.turnero.turnos.service.IDomicilioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    private IDomicilioService domicilioService;


    public DomicilioController(IDomicilioService domicilioService) {
        this.domicilioService = domicilioService;
    }
    @PostMapping
    public ResponseEntity<HttpStatus> crearDomicilio(@RequestBody DomicilioDTO domicilioDTO){
        domicilioService.guardarDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Optional<DomicilioDTO> buscarDomicilio(@PathVariable Long id) throws ResourceNotFoundException{

       return domicilioService.buscarDomicilio(id);
    }
    @GetMapping
    public Optional<List<DomicilioDTO>>  listarDomicilios(){
        return domicilioService.listarTodos();
    }
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> actualizarDomicilio(@RequestBody DomicilioDTO domicilioDTO,@PathVariable Long id) throws ResourceNotFoundException{
        if(domicilioDTO.getId()==id) {
            domicilioService.actualizarDomicilio(domicilioDTO);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        else{
            throw new ResourceNotFoundException("El id pasado por parametro No coincide con el id dentro de la petición.");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarDomicilio(@PathVariable Long id) throws ResourceNotFoundException {

            domicilioService.eliminarDomicilio(id);

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
