package com.turnero.turnos.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PacienteDTOTest {

    @Test
    void getId() {
        DomicilioDTO domicilioDTO=new DomicilioDTO("CERCA",987,"sao","rn");
        PacienteDTO pacienteDTO=new PacienteDTO(1L,"ODO","TOLO","23323232",domicilioDTO, LocalDate.now());
        assertEquals(1L,pacienteDTO.getId());
    }

    @Test
    void setId() {
        DomicilioDTO domicilioDTO=new DomicilioDTO("CERCA",987,"sao","rn");
        PacienteDTO pacienteDTO=new PacienteDTO(1L,"ODO","TOLO","23323232",domicilioDTO, LocalDate.now());
        pacienteDTO.setId(122L);
        assertEquals(122L,pacienteDTO.getId());
    }

    @Test
    void getNombre() {
        DomicilioDTO domicilioDTO=new DomicilioDTO("CERCA",987,"sao","rn");
        PacienteDTO pacienteDTO=new PacienteDTO(1L,"ODO","TOLO","23323232",domicilioDTO, LocalDate.now());
        assertEquals("ODO",pacienteDTO.getNombre());
    }

    @Test
    void setNombre() {
        DomicilioDTO domicilioDTO=new DomicilioDTO("CERCA",987,"sao","rn");
        PacienteDTO pacienteDTO=new PacienteDTO(1L,"ODO","TOLO","23323232",domicilioDTO, LocalDate.now());
        pacienteDTO.setNombre("NUEVO");
        assertEquals("NUEVO",pacienteDTO.getNombre());
    }

    @Test
    void getApellido() {
        DomicilioDTO domicilioDTO=new DomicilioDTO("CERCA",987,"sao","rn");
        PacienteDTO pacienteDTO=new PacienteDTO(1L,"ODO","TOLO","23323232",domicilioDTO, LocalDate.now());
        assertEquals("TOLO",pacienteDTO.getApellido());
    }

    @Test
    void setApellido() {
        DomicilioDTO domicilioDTO=new DomicilioDTO("CERCA",987,"sao","rn");
        PacienteDTO pacienteDTO=new PacienteDTO(1L,"ODO","TOLO","23323232",domicilioDTO, LocalDate.now());
        pacienteDTO.setApellido("NUEVO");
        assertEquals("NUEVO",pacienteDTO.getApellido());
    }

    @Test
    void getDni() {
        DomicilioDTO domicilioDTO=new DomicilioDTO("CERCA",987,"sao","rn");
        PacienteDTO pacienteDTO=new PacienteDTO(1L,"ODO","TOLO","23323232",domicilioDTO, LocalDate.now());
        assertEquals("23323232",pacienteDTO.getDni());
    }

    @Test
    void setDni() {
        DomicilioDTO domicilioDTO=new DomicilioDTO("CERCA",987,"sao","rn");
        PacienteDTO pacienteDTO=new PacienteDTO(1L,"ODO","TOLO","23323232",domicilioDTO, LocalDate.now());
        pacienteDTO.setDni("xxx-zzz");
        assertEquals("xxx-zzz",pacienteDTO.getDni());
    }

    @Test
    void getFechaDeAlta() {
        DomicilioDTO domicilioDTO=new DomicilioDTO("CERCA",987,"sao","rn");
        PacienteDTO pacienteDTO=new PacienteDTO(1L,"ODO","TOLO","23323232",domicilioDTO, LocalDate.now());
        assertEquals(LocalDate.now(),pacienteDTO.getFechaDeAlta());
    }

    @Test
    void setFechaDeAlta() {
        DomicilioDTO domicilioDTO=new DomicilioDTO("CERCA",987,"sao","rn");
        PacienteDTO pacienteDTO=new PacienteDTO(1L,"ODO","TOLO","23323232",domicilioDTO, LocalDate.now());
        LocalDate fecha=pacienteDTO.getFechaDeAlta();
        pacienteDTO.setFechaDeAlta(fecha.plusDays(5));

        assertNotEquals(fecha,pacienteDTO.getFechaDeAlta());
    }

    @Test
    void getDomicilio() {
        DomicilioDTO domicilioDTO=new DomicilioDTO("CERCA",987,"sao","rn");
        PacienteDTO pacienteDTO=new PacienteDTO(1L,"ODO","TOLO","23323232",domicilioDTO, LocalDate.now());
        assertEquals(domicilioDTO,pacienteDTO.getDomicilio());
    }

    @Test
    void setDomicilio() {
        DomicilioDTO domicilioDTO=new DomicilioDTO("CERCA",987,"sao","rn");
        PacienteDTO pacienteDTO=new PacienteDTO(1L,"ODO","TOLO","23323232",domicilioDTO, LocalDate.now());
        DomicilioDTO domicilioDTO1=pacienteDTO.getDomicilio();
        DomicilioDTO domicilioDTO2=new DomicilioDTO("otro",555,"lg","rn");
        pacienteDTO.setDomicilio(domicilioDTO2);


      assertNotEquals(domicilioDTO1,pacienteDTO.getDomicilio());
    }
}