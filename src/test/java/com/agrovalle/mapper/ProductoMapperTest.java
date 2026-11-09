package com.agrovalle.mapper;

import com.agrovalle.dto.ProductoDTO;
import com.agrovalle.model.Producto;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductoMapperTest {

    @Test
    void testToDTO() {

        Producto producto = new Producto();

        producto.setId(1L);
        producto.setNombre("Tomate");
        producto.setDescripcion("Organico");
        producto.setPrecio(new BigDecimal("3000"));
        producto.setCantidadKg(100);
        producto.setMunicipio("Palmira");
        producto.setCategoria("Verdura");

        ProductoDTO dto =
                ProductoMapper.toDTO(producto);

        assertEquals(1L, dto.getId());
        assertEquals("Tomate", dto.getNombre());
    }

    @Test
    void testToEntity() {

        ProductoDTO dto = new ProductoDTO(
                1L,
                "Tomate",
                "Organico",
                new BigDecimal("3000"),
                100,
                "Palmira",
                "Verdura"
        );

        Producto producto =
                ProductoMapper.toEntity(dto);

        assertEquals(1L, producto.getId());
        assertEquals("Tomate", producto.getNombre());
        assertEquals("Palmira", producto.getMunicipio());
    }
    @Test
void testConstructor() {
    new ProductoMapper();
}

}
