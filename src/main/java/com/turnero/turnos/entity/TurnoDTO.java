package com.turnero.turnos.entity;


import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class TurnoDTO {
    private Long id;
    private LocalTime hora= LocalTime.now();
    private Paciente paciente;
    private Odontologo odontologo;
    private LocalDate fecha=LocalDate.now();
    private Time horaturno;
    private LocalDate diaturno;

    public TurnoDTO(Long id, LocalTime hora, Paciente paciente, Odontologo odontologo, LocalDate fecha, Time horaturno, LocalDate diaturno) {
        this.id = id;
        this.hora = hora;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
        this.horaturno = horaturno;
        this.diaturno = diaturno;
    }

    public TurnoDTO(){

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Time getHoraturno() {
        return horaturno;
    }

    public void setHoraturno(Time horaturno) {
        this.horaturno = horaturno;
    }

    public LocalDate getDiaturno() {
        return diaturno;
    }

    public void setDiaturno(LocalDate diaturno) {
        this.diaturno = diaturno;
    }
}
