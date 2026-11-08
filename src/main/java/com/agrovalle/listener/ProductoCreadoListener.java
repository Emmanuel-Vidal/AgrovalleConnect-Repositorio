package com.agrovalle.listener;

import com.agrovalle.event.ProductoCreadoEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProductoCreadoListener {

    @EventListener
    public void manejarProductoCreado(
            ProductoCreadoEvent event) {

        System.out.println(
                "Producto creado: "
                        + event.getProducto().getNombre()
        );
    }
}