package com.turnero.turnos.entity;

public class UsuarioDTO {
    private Long id;
    private String username;
    private String password;
    private String rol;

    public UsuarioDTO(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public UsuarioDTO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }
}
