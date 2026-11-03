package main.java.com.agrovalle.model;

public class Producto {
    private String id;
    private String nombre;
    private String categoria; // Ej: "Frutas", "Hortalizas", "Granos"
    private double precioPorKg;
    private double stockKg;
    private String idAgricultor; // ID del Usuario que lo cultiva

    public Producto(String id, String nombre, String categoria, double precioPorKg, double stockKg, String idAgricultor) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioPorKg = precioPorKg;
        this.stockKg = stockKg;
        this.idAgricultor = idAgricultor;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public double getPrecioPorKg() { return precioPorKg; }
    public void setPrecioPorKg(double precioPorKg) { this.precioPorKg = precioPorKg; }

    public double getStockKg() { return stockKg; }
    public void setStockKg(double stockKg) { this.stockKg = stockKg; }

    public String getIdAgricultor() { return idAgricultor; }
    public void setIdAgricultor(String idAgricultor) { this.idAgricultor = idAgricultor; }

    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precioPorKg=" + precioPorKg +
                ", stockKg=" + stockKg +
                ", idAgricultor='" + idAgricultor + '\'' +
                '}';
    }
}