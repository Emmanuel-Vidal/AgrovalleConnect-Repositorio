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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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
}