package com.turnero.turnos.entity;


import java.time.LocalDate;
import java.time.LocalTime;

public class TurnoDTO {
    private Long id;
    private LocalTime hora= LocalTime.now();
    private Paciente paciente;
    private Odontologo odontologo;
    private LocalDate fecha=LocalDate.now();
    private LocalTime horaturno;

    public TurnoDTO(Long id, LocalTime hora, Paciente paciente, Odontologo odontologo, LocalDate fecha, LocalTime horaturno) {
        this.id = id;
        this.hora = hora;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
        this.horaturno = horaturno;
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

    public LocalTime getHoraturno() {
        return horaturno;
    }

    public void setHoraturno(LocalTime horaturno) {
        this.horaturno = horaturno;
    }
}
