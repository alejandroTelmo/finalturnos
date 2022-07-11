package com.turnero.turnos.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DomicilioDTOTest {


    @Test
    void getId() {
        DomicilioDTO domicilioDTO=new DomicilioDTO("creek",890,"lg","rn");
        domicilioDTO.setId(1L);
        assertEquals(5L,domicilioDTO.getId());
    }

    @Test
    void setId() {
        DomicilioDTO domicilioDTO=new DomicilioDTO("creek",890,"lg","rn");
        domicilioDTO.setId(1L);
        domicilioDTO.setId(115L);
        assertEquals(115L,domicilioDTO.getId());
    }

    @Test
    void getCalle() {
        DomicilioDTO domicilioDTO=new DomicilioDTO("creek",890,"lg","rn");
        domicilioDTO.setId(1L);
        assertEquals("creek",domicilioDTO.getCalle());
    }

    @Test
    void setCalle() {
        DomicilioDTO domicilioDTO=new DomicilioDTO("creek",890,"lg","rn");
        domicilioDTO.setCalle("otra calle mas lejana");
        assertEquals("otra calle mas lejana",domicilioDTO.getCalle());
    }

    @Test
    void getNumero() {
        DomicilioDTO domicilioDTO=new DomicilioDTO("creek",890,"lg","rn");
        assertEquals(890,domicilioDTO.getNumero());
    }

    @Test
    void setNumero() {
        DomicilioDTO domicilioDTO=new DomicilioDTO("creek",890,"lg","rn");
        domicilioDTO.setNumero(3333);
        assertEquals(3333,domicilioDTO.getNumero());
    }

    @Test
    void getCiudad() {
        DomicilioDTO domicilioDTO=new DomicilioDTO("creek",890,"lg","rn");
        assertEquals("lg",domicilioDTO.getCiudad());
    }

    @Test
    void setCiudad() {
        DomicilioDTO domicilioDTO=new DomicilioDTO("creek",890,"lg","rn");
        domicilioDTO.setCiudad("sao");
        assertEquals("sao",domicilioDTO.getCiudad());
    }

    @Test
    void getProvincia() {
        DomicilioDTO domicilioDTO=new DomicilioDTO("creek",890,"lg","rn");
        assertEquals("rn",domicilioDTO.getProvincia());
    }

    @Test
    void setProvincia() {
        DomicilioDTO domicilioDTO=new DomicilioDTO("creek",890,"lg","rn");
        domicilioDTO.setProvincia("neuquen");
        assertEquals("neuquen",domicilioDTO.getProvincia());
    }
}