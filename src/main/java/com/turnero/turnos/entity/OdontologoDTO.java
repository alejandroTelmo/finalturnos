package com.turnero.turnos.entity;




public class OdontologoDTO {
    private String nombre;
    private String apellido;
    private Integer numeroMatricula;
    private Long id;

    public OdontologoDTO(String nombre, String apellido, Integer numeroMatricula, Long id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroMatricula = numeroMatricula;
        this.id = id;
    }
    public OdontologoDTO(){

    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(Integer numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
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
}
