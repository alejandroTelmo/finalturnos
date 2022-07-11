package com.turnero.turnos.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OdontologoDTOTest {

    @Test
    void getApellido() {
        OdontologoDTO odontologoDTO=new OdontologoDTO("odon","tologo",888,1L);
        assertEquals("tologo",odontologoDTO.getApellido());
    }

    @Test
    void setApellido() {
        OdontologoDTO odontologoDTO=new OdontologoDTO("odon","tologo",888,1L);
        odontologoDTO.setApellido("nuevo");
        assertEquals("nuevo",odontologoDTO.getApellido());
    }

    @Test
    void getNumeroMatricula() {
        OdontologoDTO odontologoDTO=new OdontologoDTO("odon","tologo",888,1L);
        assertEquals(888,odontologoDTO.getNumeroMatricula());
    }

    @Test
    void setNumeroMatricula() {
        OdontologoDTO odontologoDTO=new OdontologoDTO("odon","tologo",888,1L);
        odontologoDTO.setNumeroMatricula(222);
        assertEquals(222,odontologoDTO.getNumeroMatricula());
    }

    @Test
    void getId() {
        OdontologoDTO odontologoDTO=new OdontologoDTO("odon","tologo",888,1L);
        assertEquals(1L,odontologoDTO.getId());
    }

    @Test
    void setId() {
        OdontologoDTO odontologoDTO=new OdontologoDTO("odon","tologo",888,1L);
        odontologoDTO.setNumeroMatricula(222);
        assertEquals(222,odontologoDTO.getNumeroMatricula());
    }

    @Test
    void getNombre() {
        OdontologoDTO odontologoDTO=new OdontologoDTO("odon","tologo",888,1L);
        assertEquals("odon",odontologoDTO.getNombre());
    }

    @Test
    void setNombre() {
        OdontologoDTO odontologoDTO=new OdontologoDTO("odon","tologo",888,1L);
        odontologoDTO.setNombre("otro odon");
        assertEquals("otro odon",odontologoDTO.getNombre());
    }
}