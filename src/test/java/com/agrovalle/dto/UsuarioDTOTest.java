package com.agrovalle.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioDTOTest {

    @Test
    void testGettersAndSetters() {

        UsuarioDTO dto = new UsuarioDTO();

        dto.setCedula("123");
        dto.setNombre("Emmanuel");
        dto.setCorreo("emmanuel@test.com");
        dto.setRol("AGRICULTOR");

        assertEquals("123", dto.getCedula());
        assertEquals("Emmanuel", dto.getNombre());
        assertEquals("emmanuel@test.com", dto.getCorreo());
        assertEquals("AGRICULTOR", dto.getRol());
    }

    @Test
    void testConstructor() {

        UsuarioDTO dto = new UsuarioDTO(
                "123",
                "Emmanuel",
                "emmanuel@test.com",
                "AGRICULTOR"
        );

        assertEquals("123", dto.getCedula());
        assertEquals("Emmanuel", dto.getNombre());
        assertEquals("emmanuel@test.com", dto.getCorreo());
        assertEquals("AGRICULTOR", dto.getRol());
    }
}