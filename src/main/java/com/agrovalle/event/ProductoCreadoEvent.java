package com.agrovalle.event;

import com.agrovalle.model.Producto;

public class ProductoCreadoEvent {

    private final Producto producto;

    public ProductoCreadoEvent(Producto producto) {
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }
}