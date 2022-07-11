package com.turnero.turnos.controller;

import com.turnero.turnos.entity.DomicilioDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DomicilioControllerTest {
    @Autowired
    DomicilioController domicilioController;

    @Test
    void crearDomicilio() {
        DomicilioDTO domicilioDTO=new DomicilioDTO();
        domicilioDTO.setCalle("crear domicilio");
        domicilioDTO.setNumero(198);
        domicilioDTO.setCiudad("lg");
        domicilioDTO.setProvincia("rn");
    //    domicilioService.guardarDomicilio(domicilioDTO);
    }

    @Test
    void buscarDomicilio() {
    }

    @Test
    void listarDomicilios() {
    }

    @Test
    void actualizarDomicilio() {
    }

    @Test
    void eliminarDomicilio() {
    }
}