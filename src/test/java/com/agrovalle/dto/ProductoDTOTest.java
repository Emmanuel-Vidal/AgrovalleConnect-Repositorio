package com.agrovalle.dto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductoDTOTest {

    @Test
    void testGettersAndSetters() {

        ProductoDTO dto = new ProductoDTO();

        dto.setId(1L);
        dto.setNombre("Tomate");
        dto.setDescripcion("Organico");
        dto.setPrecio(new BigDecimal("3000"));
        dto.setCantidadKg(100);
        dto.setMunicipio("Palmira");
        dto.setCategoria("Verdura");

        assertEquals(1L, dto.getId());
        assertEquals("Tomate", dto.getNombre());
        assertEquals("Organico", dto.getDescripcion());
        assertEquals(new BigDecimal("3000"), dto.getPrecio());
        assertEquals(100, dto.getCantidadKg());
        assertEquals("Palmira", dto.getMunicipio());
        assertEquals("Verdura", dto.getCategoria());
    }

    @Test
    void testConstructor() {

        ProductoDTO dto = new ProductoDTO(
                1L,
                "Tomate",
                "Organico",
                new BigDecimal("3000"),
                100,
                "Palmira",
                "Verdura"
        );

        assertEquals(1L, dto.getId());
        assertEquals("Tomate", dto.getNombre());
    }
}