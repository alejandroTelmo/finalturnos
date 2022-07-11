package com.turnero.turnos.entity;

import java.time.LocalDate;


public class PacienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private DomicilioDTO domicilio;

    private LocalDate fechaDeAlta= LocalDate.now();;

    public PacienteDTO(Long id, String nombre, String apellido, String dni, DomicilioDTO domicilio, LocalDate fechaDeAlta) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
        this.fechaDeAlta = fechaDeAlta;
    }

    public PacienteDTO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(LocalDate fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public DomicilioDTO getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(DomicilioDTO domicilioDTO) {
        this.domicilio = domicilioDTO;
    }
}
