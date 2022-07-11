package com.turnero.turnos.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PacienteTest {

    @Test
    void getId() {
        Domicilio dom=new Domicilio("aca",11,"lg","rn");
        Paciente paciente=new Paciente(1L,"BOCA","MENTA",dom,"2625555", LocalDate.now());
        assertEquals(1L,paciente.getId());
    }

    @Test
    void setId() {
        Domicilio dom=new Domicilio("aca",11,"lg","rn");
        Paciente paciente=new Paciente(1L,"BOCA","MENTA",dom,"2625555", LocalDate.now());
        paciente.setId(3L);
        assertEquals(3L,paciente.getId());
    }

    @Test
    void getNombre() {
        Domicilio dom=new Domicilio("aca",11,"lg","rn");
        Paciente paciente=new Paciente(1L,"BOCA","MENTA",dom,"2625555", LocalDate.now());
        assertEquals("BOCA",paciente.getNombre());
    }

    @Test
    void setNombre() {
        Domicilio dom=new Domicilio("aca",11,"lg","rn");
        Paciente paciente=new Paciente(1L,"BOCA","MENTA",dom,"2625555", LocalDate.now());
        paciente.setNombre("riBBBer");
        assertEquals("riBBBer",paciente.getNombre());
    }

    @Test
    void getApellido() {
        Domicilio dom=new Domicilio("aca",11,"lg","rn");
        Paciente paciente=new Paciente(1L,"BOCA","MENTA",dom,"2625555", LocalDate.now());
        assertEquals("MENTA",paciente.getApellido());
    }

    @Test
    void setApellido() {
        Domicilio dom=new Domicilio("aca",11,"lg","rn");
        Paciente paciente=new Paciente(1L,"BOCA","MENTA",dom,"2625555", LocalDate.now());
        paciente.setApellido("riBBBer");
        assertEquals("riBBBer",paciente.getApellido());
    }

    @Test
    void getDni() {
        Domicilio dom=new Domicilio("aca",11,"lg","rn");
        Paciente paciente=new Paciente(1L,"BOCA","MENTA",dom,"2625555", LocalDate.now());
        assertEquals("2625555",paciente.getDni());
    }

    @Test
    void setDni() {
        Domicilio dom=new Domicilio("aca",11,"lg","rn");
        Paciente paciente=new Paciente(1L,"BOCA","MENTA",dom,"2625555", LocalDate.now());
        paciente.setDni("8585858");
        assertEquals("8585858",paciente.getDni());
    }

    @Test
    void getFechaDeAlta() {
        Domicilio dom=new Domicilio("aca",11,"lg","rn");
        Paciente paciente=new Paciente(1L,"BOCA","MENTA",dom,"2625555", LocalDate.now());
        assertTrue(paciente.getFechaDeAlta()!=null);
    }

    @Test
    void setFechaDeAlta() {
        Domicilio dom=new Domicilio("aca",11,"lg","rn");
        Paciente paciente=new Paciente(1L,"BOCA","MENTA",dom,"2625555", LocalDate.now());
        LocalDate fecha=paciente.getFechaDeAlta();

        paciente.setFechaDeAlta(fecha.plusDays(1));
        LocalDate fecha1=paciente.getFechaDeAlta();
      assertNotEquals(fecha,fecha1);
    }
}