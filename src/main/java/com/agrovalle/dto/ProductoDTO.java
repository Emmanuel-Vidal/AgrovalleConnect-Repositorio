package com.agrovalle.dto;

import java.math.BigDecimal;

public class ProductoDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer cantidadKg;
    private String municipio;
    private String categoria;

    public ProductoDTO() {
    }

    public ProductoDTO(
            Long id,
            String nombre,
            String descripcion,
            BigDecimal precio,
            Integer cantidadKg,
            String municipio,
            String categoria) {

        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadKg = cantidadKg;
        this.municipio = municipio;
        this.categoria = categoria;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getCantidadKg() {
        return cantidadKg;
    }

    public void setCantidadKg(Integer cantidadKg) {
        this.cantidadKg = cantidadKg;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}