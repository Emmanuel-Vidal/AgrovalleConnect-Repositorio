package com.agrovalle.service;

import com.agrovalle.model.Producto;
import com.agrovalle.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarTodos() {

        Producto p1 = new Producto(
                "Tomate",
                "Orgánico",
                new BigDecimal("3000"),
                100,
                "Palmira",
                "Verdura"
        );

        Producto p2 = new Producto(
                "Papa",
                "Parda",
                new BigDecimal("2000"),
                200,
                "Cali",
                "Tubérculo"
        );

        when(productoRepository.findAll())
                .thenReturn(Arrays.asList(p1, p2));

        List<Producto> resultados = productoService.listarTodos();

        assertEquals(2, resultados.size());
    }
    @Test
void testObtenerPorId() {

    Producto producto = new Producto(
            "Tomate",
            "Organico",
            new BigDecimal("3000"),
            100,
            "Palmira",
            "Verdura"
    );

    when(productoRepository.findById(1L))
            .thenReturn(Optional.of(producto));

    Optional<Producto> resultado =
            productoService.obtenerPorId(1L);

    assertTrue(resultado.isPresent());
}
@Test
void testListarPorMunicipio() {

    Producto producto = new Producto(
            "Tomate",
            "Organico",
            new BigDecimal("3000"),
            100,
            "Palmira",
            "Verdura"
    );

    when(productoRepository.findByMunicipio("Palmira"))
            .thenReturn(Arrays.asList(producto));

    List<Producto> resultado =
            productoService.listarPorMunicipio("Palmira");

    assertEquals(1, resultado.size());
}
@Test
void testGuardarProducto() {

    Producto producto = new Producto(
            "Tomate",
            "Organico",
            new BigDecimal("3000"),
            100,
            "Palmira",
            "Verdura"
    );

    when(productoRepository.save(producto))
            .thenReturn(producto);

    Producto resultado =
            productoService.guardar(producto);

    assertNotNull(resultado);
}
@Test
void testEliminarProducto() {

    productoService.eliminar(1L);

    verify(productoRepository)
            .deleteById(1L);
}
    
}
