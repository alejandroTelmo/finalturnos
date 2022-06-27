package com.turnero.turnos.entity;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "turnos")
public class Turno  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalTime hora =LocalTime.now();
    private LocalTime horaturno;
    @ManyToOne
    @JoinColumn(name = "paciente_id",nullable = false)
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "odontologo_id",nullable = false)
    private Odontologo odontologo;

    private LocalDate fecha=LocalDate.now();

    public Turno(Long id, LocalTime hora, LocalTime horaturno, Paciente paciente, Odontologo odontologo, LocalDate fecha) {
        this.id = id;
        this.hora = hora;
        this.horaturno = horaturno;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
    }

    public Turno(){

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
