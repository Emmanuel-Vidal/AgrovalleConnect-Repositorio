package com.agrovalle.controller;

import com.agrovalle.model.Usuario;
import com.agrovalle.service.UsuarioService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioControllerTest {

    @Test
    void testListar() throws Exception {

        UsuarioController controller = new UsuarioController();

        Usuario usuario = new Usuario();
        usuario.setCedula("123");

        UsuarioService service = new UsuarioService() {
            @Override
            public List<Usuario> listarUsuarios() {
                return Arrays.asList(usuario);
            }
        };

        Field field =
                UsuarioController.class.getDeclaredField("usuarioService");

        field.setAccessible(true);
        field.set(controller, service);

        assertEquals(1, controller.listar().size());
    }

    @Test
    void testBuscarPorId() throws Exception {

        UsuarioController controller = new UsuarioController();

        Usuario usuario = new Usuario();
        usuario.setCedula("123");

        UsuarioService service = new UsuarioService() {
            @Override
            public Optional<Usuario> buscarPorId(String id) {
                return Optional.of(usuario);
            }
        };

        Field field =
                UsuarioController.class.getDeclaredField("usuarioService");

        field.setAccessible(true);
        field.set(controller, service);

        assertEquals(
                200,
                controller.buscarPorId("123")
                        .getStatusCode()
                        .value()
        );
    }
}