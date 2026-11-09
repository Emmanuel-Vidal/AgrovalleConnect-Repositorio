package com.agrovalle.mapper;

import com.agrovalle.dto.UsuarioDTO;
import com.agrovalle.model.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioMapperTest {

    @Test
    void testToDTO() {

        Usuario usuario = new Usuario();

        usuario.setCedula("123");
        usuario.setNombre("Emmanuel");
        usuario.setCorreo("emmanuel@test.com");
        usuario.setRol("AGRICULTOR");

        UsuarioDTO dto =
                UsuarioMapper.toDTO(usuario);

        assertEquals("123", dto.getCedula());
        assertEquals("Emmanuel", dto.getNombre());
        assertEquals("emmanuel@test.com", dto.getCorreo());
        assertEquals("AGRICULTOR", dto.getRol());
    }

    @Test
    void testToEntity() {

        UsuarioDTO dto = new UsuarioDTO(
                "123",
                "Emmanuel",
                "emmanuel@test.com",
                "AGRICULTOR"
        );

        Usuario usuario =
                UsuarioMapper.toEntity(dto);

        assertEquals("123", usuario.getCedula());
        assertEquals("Emmanuel", usuario.getNombre());
        assertEquals("emmanuel@test.com", usuario.getCorreo());
        assertEquals("AGRICULTOR", usuario.getRol());
    }
    @Test
void testConstructor() {
    new UsuarioMapper();
}

}