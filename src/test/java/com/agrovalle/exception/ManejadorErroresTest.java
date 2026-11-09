package com.agrovalle.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class ManejadorErroresTest {

    @Test
    void testManejarArgumentoInvalido() {

        ManejadorErrores manejador =
                new ManejadorErrores();

        ResponseEntity<String> response =
                manejador.manejarArgumentoInvalido(
                        new IllegalArgumentException("Dato inválido")
                );

        assertEquals(
                400,
                response.getStatusCode().value()
        );

        assertEquals(
                "Dato inválido",
                response.getBody()
        );
    }

    @Test
    void testManejarErrorGeneral() {

        ManejadorErrores manejador =
                new ManejadorErrores();

        ResponseEntity<String> response =
                manejador.manejarErrorGeneral(
                        new Exception("Error")
                );

        assertEquals(
                500,
                response.getStatusCode().value()
        );

        assertEquals(
                "Error interno del servidor",
                response.getBody()
        );
    }
}