package com.turnero.turnos.entity;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class TurnoTest {

    @Test
    void getId() {
        Domicilio dom=new Domicilio("aca",11,"lg","rn");
        dom.setId(1L);
        Paciente paciente=new Paciente(1L,"BOCA","MENTA",dom,"2625555", LocalDate.now());
        Odontologo odontologo=new Odontologo("yo","vos",123,1L);
        Turno turno=new Turno(1L, LocalTime.now(), new Time(20,30,30), LocalDate.now(),paciente,odontologo,LocalDate.now());
        assertEquals(1L,turno.getId());
    }

    @Test
    void setId() {
        Domicilio dom=new Domicilio("aca",11,"lg","rn");
        dom.setId(1L);
        Paciente paciente=new Paciente(1L,"BOCA","MENTA",dom,"2625555", LocalDate.now());
        Odontologo odontologo=new Odontologo("yo","vos",123,1L);
        Turno turno=new Turno(1L, LocalTime.now(), new Time(20,30,30), LocalDate.now(),paciente,odontologo,LocalDate.now());
        turno.setId(55L);
        assertEquals(55L,turno.getId());
    }

    @Test
    void getHora() {
        Domicilio dom=new Domicilio("aca",11,"lg","rn");
        dom.setId(1L);
        Paciente paciente=new Paciente(1L,"BOCA","MENTA",dom,"2625555", LocalDate.now());
        Odontologo odontologo=new Odontologo("yo","vos",123,1L);
        Turno turno=new Turno(1L, LocalTime.now(), new Time(20,30,30), LocalDate.now(),paciente,odontologo,LocalDate.now());
        LocalTime fecha=turno.getHora();
        assertEquals(fecha,turno.getHora());
    }

    @Test
    void setHora() {
        Domicilio dom=new Domicilio("aca",11,"lg","rn");
        dom.setId(1L);
        Paciente paciente=new Paciente(1L,"BOCA","MENTA",dom,"2625555", LocalDate.now());
        Odontologo odontologo=new Odontologo("yo","vos",123,1L);
        Turno turno=new Turno(1L, LocalTime.now(), new Time(20,30,30), LocalDate.now(),paciente,odontologo,LocalDate.now());
        LocalTime fecha=turno.getHora();
        turno.setHora(fecha.plusHours(3));
        assertNotEquals(fecha,turno.getHora());
    }

    @Test
    void getPaciente() {
        Domicilio dom=new Domicilio("aca",11,"lg","rn");

        Paciente paciente=new Paciente(1L,"BOCA","MENTA",dom,"2625555", LocalDate.now());
        Odontologo odontologo=new Odontologo("yo","vos",123,1L);
        Turno turno=new Turno(1L, LocalTime.now(), new Time(20,30,30), LocalDate.now(),paciente,odontologo,LocalDate.now());

        assertEquals(paciente,turno.getPaciente());
    }

    @Test
    void setPaciente() {
        Domicilio dom=new Domicilio("aca",11,"lg","rn");
        Paciente paciente=new Paciente(1L,"BOCA","MENTA",dom,"2625555", LocalDate.now());
        Odontologo odontologo=new Odontologo("yo","vos",123,1L);
        Turno turno=new Turno(1L, LocalTime.now(), new Time(20,30,30), LocalDate.now(),paciente,odontologo,LocalDate.now());
        Paciente paciente1=new Paciente(2L,"riber","choco",dom,"2625555", LocalDate.now());
        turno.setPaciente(paciente1);

        assertEquals(paciente1,turno.getPaciente());
    }

    @Test
    void getOdontologo() {
        Domicilio dom=new Domicilio("aca",11,"lg","rn");
        Paciente paciente=new Paciente(1L,"BOCA","MENTA",dom,"2625555", LocalDate.now());
        Odontologo odontologo=new Odontologo("yo","vos",123,1L);
        Turno turno=new Turno(1L, LocalTime.now(), new Time(20,30,30), LocalDate.now(),paciente,odontologo,LocalDate.now());

        assertEquals(odontologo,turno.getOdontologo());
    }

    @Test
    void setOdontologo() {

        Domicilio dom=new Domicilio("aca",11,"lg","rn");
        Paciente paciente=new Paciente(1L,"BOCA","MENTA",dom,"2625555", LocalDate.now());

        Odontologo odontologo=new Odontologo("yo","vos",123,1L);

        Turno turno=new Turno(1L, LocalTime.now(), new Time(20,30,30), LocalDate.now(),paciente,odontologo,LocalDate.now());
        Odontologo odontologo1=new Odontologo("otro","sos",12255,5L);
        turno.setOdontologo(odontologo1);
        assertEquals(odontologo1,turno.getOdontologo());
    }

    @Test
    void getFecha() {
        Domicilio dom=new Domicilio("aca",11,"lg","rn");
        Paciente paciente=new Paciente(1L,"BOCA","MENTA",dom,"2625555", LocalDate.now());
        Odontologo odontologo=new Odontologo("yo","vos",123,1L);
        Turno turno=new Turno(1L, LocalTime.now(), new Time(20,30,30), LocalDate.now(),paciente,odontologo,LocalDate.now());
        assertEquals(LocalDate.now(),turno.getFecha());
    }

    @Test
    void setFecha() {
        Domicilio dom=new Domicilio("aca",11,"lg","rn");
        Paciente paciente=new Paciente(1L,"BOCA","MENTA",dom,"2625555", LocalDate.now());
        Odontologo odontologo=new Odontologo("yo","vos",123,1L);
        Turno turno=new Turno(1L, LocalTime.now(), new Time(20,30,30), LocalDate.now(),paciente,odontologo,LocalDate.now());
        LocalDate fecha=turno.getFecha();
        turno.setFecha(fecha.plusDays(2));
        assertNotEquals(fecha,turno.getFecha());
    }

    @Test
    void getHoraturno() {
        Domicilio dom=new Domicilio("aca",11,"lg","rn");
        Paciente paciente=new Paciente(1L,"BOCA","MENTA",dom,"2625555", LocalDate.now());
        Odontologo odontologo=new Odontologo("yo","vos",123,1L);
        Turno turno=new Turno(1L, LocalTime.now(), new Time(20,30,30), LocalDate.now(),paciente,odontologo,LocalDate.now());
        Time fecha=turno.getHoraturno();

        assertEquals(fecha,turno.getHoraturno());
    }

    @Test
    void setHoraturno() {
        Domicilio dom=new Domicilio("aca",11,"lg","rn");
        Paciente paciente=new Paciente(1L,"BOCA","MENTA",dom,"2625555", LocalDate.now());
        Odontologo odontologo=new Odontologo("yo","vos",123,1L);
        Turno turno=new Turno(1L, LocalTime.now(), new Time(20,30,30), LocalDate.now(),paciente,odontologo,LocalDate.now());

        Time fecha= turno.getHoraturno();
        turno.setHoraturno(new Time(22,39,30));
        assertNotEquals(fecha,turno.getHoraturno());
    }

    @Test
    void getDiaturno() {
        Domicilio dom=new Domicilio("aca",11,"lg","rn");
        Paciente paciente=new Paciente(1L,"BOCA","MENTA",dom,"2625555", LocalDate.now());
        Odontologo odontologo=new Odontologo("yo","vos",123,1L);
        Turno turno=new Turno(1L, LocalTime.now(), new Time(20,30,30), LocalDate.now(),paciente,odontologo,LocalDate.now());

        assertTrue(turno.getDiaturno()!=null);
    }

    @Test
    void setDiaturno() {
        Domicilio dom=new Domicilio("aca",11,"lg","rn");
        Paciente paciente=new Paciente(1L,"BOCA","MENTA",dom,"2625555", LocalDate.now());
        Odontologo odontologo=new Odontologo("yo","vos",123,1L);
        Turno turno=new Turno(1L, LocalTime.now(), new Time(20,30,30), LocalDate.now(),paciente,odontologo,LocalDate.now());

        LocalDate fecha=turno.getDiaturno();
        turno.setDiaturno(fecha.plusDays(2));
        assertNotEquals(fecha,turno.getDiaturno());
    }
}