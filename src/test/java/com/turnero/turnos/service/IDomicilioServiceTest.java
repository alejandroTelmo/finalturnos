package com.turnero.turnos.service;

import com.turnero.turnos.entity.DomicilioDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IDomicilioServiceTest {
    @Autowired
    private IDomicilioService domicilioService;


    @Test
    public void crearDomicilio(){
        DomicilioDTO domicilioDTO=new DomicilioDTO();
        domicilioDTO.setId(1L);
        domicilioDTO.setCalle("MONSTRUO");
        domicilioDTO.setNumero(198);
        domicilioDTO.setCiudad("lg");
        domicilioDTO.setProvincia("rn");
        domicilioService.guardarDomicilio(domicilioDTO);
        DomicilioDTO domicilioDTO1=domicilioService.buscarDomicilio(1L);

        assertTrue(domicilioDTO1.getId()==1L);
    }

    @Test
    public void eliminarDomicilio(){



        domicilioService.eliminarDomicilio(1L);
        DomicilioDTO domicilioDTO1=domicilioService.buscarDomicilio(1L);
        assertNull(domicilioDTO1);
    }
}