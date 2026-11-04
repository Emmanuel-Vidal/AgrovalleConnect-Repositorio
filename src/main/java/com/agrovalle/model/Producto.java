package com.agrovalle.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String tipoCultivo;
    private BigDecimal cantidadKg;
    private BigDecimal precioPorKg;
    private LocalDate fechaCosecha;

    public Producto() {}

    // Getters y Setters explícitos
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTipoCultivo() { return tipoCultivo; }
    public void setTipoCultivo(String tipoCultivo) { this.tipoCultivo = tipoCultivo; }

    public BigDecimal getCantidadKg() { return cantidadKg; }
    public void setCantidadKg(BigDecimal cantidadKg) { this.cantidadKg = cantidadKg; }

    public BigDecimal getPrecioPorKg() { return precioPorKg; }
    public void setPrecioPorKg(BigDecimal precioPorKg) { this.precioPorKg = precioPorKg; }

    public LocalDate getFechaCosecha() { return fechaCosecha; }
    public void setFechaCosecha(LocalDate fechaCosecha) { this.fechaCosecha = fechaCosecha; }
}