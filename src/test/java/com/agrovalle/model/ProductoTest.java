package com.agrovalle.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductoTest {

@Test
void testGettersAndSetters() {

    Producto producto = new Producto();

    producto.setId(1L);
    producto.setNombre("Tomate");
    producto.setDescripcion("Organico");
    producto.setPrecio(new BigDecimal("3000"));
    producto.setCantidadKg(100);
    producto.setMunicipio("Palmira");
    producto.setCategoria("Verdura");

    assertEquals(1L, producto.getId());
    assertEquals("Tomate", producto.getNombre());
    assertEquals("Organico", producto.getDescripcion());
    assertEquals(new BigDecimal("3000"), producto.getPrecio());
    assertEquals(100, producto.getCantidadKg());
    assertEquals("Palmira", producto.getMunicipio());
    assertEquals("Verdura", producto.getCategoria());
}
}