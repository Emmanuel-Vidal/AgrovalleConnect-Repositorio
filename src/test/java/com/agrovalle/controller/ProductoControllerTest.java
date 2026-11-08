package com.agrovalle.controller;

import com.agrovalle.model.Producto;
import com.agrovalle.service.ProductoService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductoControllerTest {

    @Test
    void testListarProductos() throws Exception {

        ProductoController controller = new ProductoController();

        Producto producto = new Producto(
                "Tomate",
                "Organico",
                new BigDecimal("3000"),
                100,
                "Palmira",
                "Verdura"
        );

        ProductoService service = new ProductoService() {
            @Override
            public List<Producto> listarTodos() {
                return Arrays.asList(producto);
            }
        };

        Field field =
                ProductoController.class.getDeclaredField("productoService");

        field.setAccessible(true);
        field.set(controller, service);

        assertEquals(1, controller.listarProductos().size());
    }

    @Test
    void testObtenerProducto() throws Exception {

        ProductoController controller = new ProductoController();

        Producto producto = new Producto(
                "Tomate",
                "Organico",
                new BigDecimal("3000"),
                100,
                "Palmira",
                "Verdura"
        );

        ProductoService service = new ProductoService() {
            @Override
            public Optional<Producto> obtenerPorId(Long id) {
                return Optional.of(producto);
            }
        };

        Field field =
                ProductoController.class.getDeclaredField("productoService");

        field.setAccessible(true);
        field.set(controller, service);

        assertEquals(
                200,
                controller.obtenerProducto(1L)
                        .getStatusCode()
                        .value()
        );
    }
}