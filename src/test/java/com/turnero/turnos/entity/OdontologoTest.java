package com.turnero.turnos.entity;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OdontologoTest {

    @Test
    void getNombre() {
      Odontologo odontologo=new Odontologo("yo","vos",123,1L);
      assertEquals("yo",odontologo.getNombre());
    }

    @Test
    void setNombre() {
        Odontologo odontologo=new Odontologo("yo","vos",123,1L);
        odontologo.setNombre("otro");
        assertEquals("otro",odontologo.getNombre());
    }

    @Test
    void getApellido() {
        Odontologo odontologo=new Odontologo("yo","vos",123,1L);
        assertEquals("vos",odontologo.getApellido());
    }

    @Test
    void setApellido() {
        Odontologo odontologo=new Odontologo("yo","vos",123,1L);
        odontologo.setApellido("cambiamos");
        assertEquals("cambiamos",odontologo.getApellido());
    }

    @Test
    void getNumeroMatricula() {
        Odontologo odontologo=new Odontologo("yo","vos",123,1L);
        assertEquals(123,odontologo.getNumeroMatricula());
    }

    @Test
    void setNumeroMatricula() {
        Odontologo odontologo=new Odontologo("yo","vos",123,1L);
        odontologo.setNumeroMatricula(999);
        assertEquals(999,odontologo.getNumeroMatricula());
    }

    @Test
    void getId() {
        Odontologo odontologo=new Odontologo("yo","vos",123,1L);
        assertEquals(1L,odontologo.getId());
    }

    @Test
    void setId() {
        Odontologo odontologo=new Odontologo("yo","vos",123,1L);
        odontologo.setId(666L);
        assertEquals(666L,odontologo.getId());
    }

    @Test
    void getTurnos() {



    }

    @Test
    void setTurnos() {

    }
}