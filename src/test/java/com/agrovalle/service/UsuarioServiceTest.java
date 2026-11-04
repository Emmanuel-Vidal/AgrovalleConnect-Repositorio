package com.agrovalle.service;

import com.agrovalle.model.Usuario;
import com.agrovalle.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarUsuarios() {

        Usuario usuario1 = new Usuario();
        usuario1.setCedula("111");
        usuario1.setNombre("Juan");

        Usuario usuario2 = new Usuario();
        usuario2.setCedula("222");
        usuario2.setNombre("Maria");

        when(usuarioRepository.findAll())
                .thenReturn(Arrays.asList(usuario1, usuario2));

        List<Usuario> usuarios = usuarioService.listarUsuarios();

        assertEquals(2, usuarios.size());
    }

    @Test
    void testBuscarPorId() {

        Usuario usuario = new Usuario();
        usuario.setCedula("123");

        when(usuarioRepository.findById("123"))
                .thenReturn(Optional.of(usuario));

        Optional<Usuario> resultado =
                usuarioService.buscarPorId("123");

        assertTrue(resultado.isPresent());
        assertEquals("123", resultado.get().getCedula());
    }

    @Test
    void testGuardarUsuario() {

        Usuario usuario = new Usuario();
        usuario.setCedula("123");

        when(usuarioRepository.save(usuario))
                .thenReturn(usuario);

        Usuario resultado =
                usuarioService.guardarUsuario(usuario);

        assertNotNull(resultado);
        assertEquals("123", resultado.getCedula());
    }

    @Test
    void testEliminarUsuario() {

        usuarioService.eliminarUsuario("123");

        verify(usuarioRepository, times(1))
                .deleteById("123");
    }
}
