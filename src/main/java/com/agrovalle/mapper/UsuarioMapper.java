package com.agrovalle.mapper;

import com.agrovalle.dto.UsuarioDTO;
import com.agrovalle.model.Usuario;

public class UsuarioMapper {

    public static UsuarioDTO toDTO(Usuario usuario) {

        return new UsuarioDTO(
                usuario.getCedula(),
                usuario.getNombre(),
                usuario.getCorreo(),
                usuario.getRol()
        );
    }

    public static Usuario toEntity(UsuarioDTO dto) {

        Usuario usuario = new Usuario();

        usuario.setCedula(dto.getCedula());
        usuario.setNombre(dto.getNombre());
        usuario.setCorreo(dto.getCorreo());
        usuario.setRol(dto.getRol());

        return usuario;
    }
}