package com.turnero.turnos.controller;


import com.turnero.turnos.entity.OdontologoDTO;
import com.turnero.turnos.exception.ResourceNotFoundException;
import com.turnero.turnos.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:63342")
@RequestMapping("/odontologos")
@RestController


public class OdontologoController {
    @Autowired
    private IOdontologoService odontologoService;


    @ResponseBody
    @PostMapping
    public ResponseEntity<HttpStatus> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        odontologoService.guardarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }


    @ResponseBody
    @GetMapping("/{id}")
    public Optional<OdontologoDTO> buscarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        return odontologoService.buscarOdontologo(id);
    }


    @ResponseBody
    @GetMapping
    public Set<OdontologoDTO> listarOdontologos() throws ResourceNotFoundException {

        return odontologoService.listarTodos();
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @ResponseBody
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> actualizarOdontologo(@RequestBody OdontologoDTO odontologoDTO,@PathVariable Long id) throws ResourceNotFoundException {
        if (odontologoDTO.getId()==id){
            odontologoService.actualizarOdontologo(odontologoDTO);
            return ResponseEntity.ok(HttpStatus.OK);
         }else
             throw new ResourceNotFoundException("El id enviado por parametro No coincide con el id de la petición.");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminar(@PathVariable Long id) throws ResourceNotFoundException {
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
