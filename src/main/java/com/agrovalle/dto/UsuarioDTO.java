package com.agrovalle.dto;

public class UsuarioDTO {

    private String cedula;
    private String nombre;
    private String correo;
    private String rol;

    public UsuarioDTO() {
    }

    public UsuarioDTO(
            String cedula,
            String nombre,
            String correo,
            String rol) {

        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}