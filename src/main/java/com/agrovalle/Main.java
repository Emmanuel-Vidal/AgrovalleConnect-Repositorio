package com.agrovalle;

import com.agrovalle.model.Usuario;
import com.agrovalle.model.Producto;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== AgrovalleConnect ===");

        // Instancia de Usuario
        Usuario usuario1 = new Usuario();
        usuario1.setCedula("U001");
        usuario1.setNombre("Emmanuel Vidal");
        usuario1.setCorreo("emmanuel@agrovalle.com");
        usuario1.setRol("AGRICULTOR");
        System.out.println("\n--- Usuario Registrado ---");
        System.out.println(usuario1);

        // Instancia de Producto asociado al Usuario
        Producto producto1 = new Producto();
        producto1.setTipoCultivo("Caña de Azúcar");
        producto1.setCantidadKg(BigDecimal.valueOf(2500.0));
        producto1.setPrecioPorKg(BigDecimal.valueOf(500.0));
        producto1.setFechaCosecha(LocalDate.now());
        System.out.println("\n--- Producto Registrado ---");
        System.out.println(producto1);
    }
}