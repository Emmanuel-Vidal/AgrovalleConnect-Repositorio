package com.agrovalle;

import com.agrovalle.model.Usuario;
import com.agrovalle.model.Producto;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== AgrovalleConnect ===");

        // Instancia de Usuario
        Usuario usuario1 = new Usuario("U001", "Emmanuel Vidal", "emmanuel@agrovalle.com", "AGRICULTOR");
        System.out.println("\n--- Usuario Registrado ---");
        System.out.println(usuario1);

        // Instancia de Producto asociado al Usuario
        Producto producto1 = new Producto("P001", "Caña de Azúcar", "Cultivos", 2500.0, 500.0, usuario1.getId());
        System.out.println("\n--- Producto Registrado ---");
        System.out.println(producto1);
    }
}