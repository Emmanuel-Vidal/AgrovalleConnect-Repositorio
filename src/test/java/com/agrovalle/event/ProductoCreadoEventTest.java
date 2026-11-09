package com.agrovalle.event;

import com.agrovalle.model.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductoCreadoEventTest {

    @Test
    void testEvento() {

        Producto producto = new Producto();

        ProductoCreadoEvent event =
                new ProductoCreadoEvent(producto);

        assertEquals(producto, event.getProducto());
    }
}