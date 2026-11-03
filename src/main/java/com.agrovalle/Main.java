package com.agrovalle;

import com.agrovalle.model.Usuario;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== AgrovalleConnect ===");

        Usuario usuario1 = new Usuario("U001", "Emmanuel Vidal", "emmanuel@agrovalle.com", "AGRICULTOR");
        System.out.println("Usuario registrado correctamente:");
        System.out.println(usuario1);
    }
}