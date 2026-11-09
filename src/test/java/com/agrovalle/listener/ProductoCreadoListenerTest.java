package com.agrovalle.listener;

import com.agrovalle.event.ProductoCreadoEvent;
import com.agrovalle.model.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ProductoCreadoListenerTest {

    @Test
    void testManejarProductoCreado() {

        Producto producto = new Producto();
        producto.setNombre("Tomate");

        ProductoCreadoEvent event =
                new ProductoCreadoEvent(producto);

        ProductoCreadoListener listener =
                new ProductoCreadoListener();

        assertDoesNotThrow(() ->
                listener.manejarProductoCreado(event)
        );
    }
}