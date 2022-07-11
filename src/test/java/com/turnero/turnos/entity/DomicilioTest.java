package com.turnero.turnos.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DomicilioTest {

    @Test
    void getId() {
        Domicilio dom=new Domicilio("otra",564,"mia","cerca");

        dom.setId(10L);

        assertEquals(10L,dom.getId());
    }

    @Test
    void setId() {
        Domicilio dom=new Domicilio("otra",564,"mia","cerca");
       dom.setId(10L);

        assertEquals(10L,dom.getId());
    }

    @Test
    void getCalle() {
        Domicilio dom=new Domicilio("otra",564,"mia","cerca");

        assertEquals("otra",dom.getCalle());

    }

    @Test
    void setCalle() {
        Domicilio dom=new Domicilio("otra",564,"mia","cerca");
        dom.setCalle("mia");

        assertEquals("mia",dom.getCalle());
    }

    @Test
    void getNumero() {
        Domicilio dom=new Domicilio("otra",564,"mia","cerca");
        assertEquals(564,dom.getNumero());
    }

    @Test
    void setNumero() {
        Domicilio dom=new Domicilio("otra",564,"mia","cerca");
        dom.setNumero(669988);
        assertEquals(669988,dom.getNumero());
    }

    @Test
    void getCiudad() {
        Domicilio dom=new Domicilio("otra",564,"mia","cerca");
        assertEquals("mia",dom.getCiudad());
    }

    @Test
    void setCiudad() {
        Domicilio dom=new Domicilio("otra",564,"mia","cerca");
        dom.setCiudad("otra ciudad");
        assertEquals("otra ciudad",dom.getCiudad());
    }

    @Test
    void getProvincia() {
        Domicilio dom=new Domicilio("otra",564,"mia","cerca");
        assertEquals("cerca",dom.getProvincia());
    }

    @Test
    void setProvincia() {
        Domicilio dom=new Domicilio("otra",564,"mia","cerca");
        dom.setProvincia("provincia modificada");
        assertEquals("provincia modificada",dom.getProvincia());
    }
}