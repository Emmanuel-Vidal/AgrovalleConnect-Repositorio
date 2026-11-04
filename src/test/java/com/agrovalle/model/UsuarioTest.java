package com.agrovalle.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void testGettersAndSetters() {

        Usuario usuario = new Usuario();

        usuario.setCedula("123");
        usuario.setNombre("Juan");
        usuario.setCorreo("juan@test.com");
        usuario.setRol("AGRICULTOR");

        assertEquals("123", usuario.getCedula());
        assertEquals("Juan", usuario.getNombre());
        assertEquals("juan@test.com", usuario.getCorreo());
        assertEquals("AGRICULTOR", usuario.getRol());
    }
}