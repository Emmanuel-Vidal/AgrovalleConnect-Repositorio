package com.agrovalle.mapper;

import com.agrovalle.dto.ProductoDTO;
import com.agrovalle.model.Producto;

public class ProductoMapper {

    public static ProductoDTO toDTO(Producto producto) {

        return new ProductoDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getCantidadKg(),
                producto.getMunicipio(),
                producto.getCategoria()
        );
    }

    public static Producto toEntity(ProductoDTO dto) {

        Producto producto = new Producto();

        producto.setId(dto.getId());
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setCantidadKg(dto.getCantidadKg());
        producto.setMunicipio(dto.getMunicipio());
        producto.setCategoria(dto.getCategoria());

        return producto;
    }
}