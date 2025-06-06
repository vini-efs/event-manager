package br.dev.viniefs.event_manager.mapstruct;

import br.dev.viniefs.event_manager.dto.UsuarioDto;
import br.dev.viniefs.event_manager.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "id", ignore = true)
    Usuario toEntity(UsuarioDto dto);

    UsuarioDto toDto(Usuario usuario);

    List<UsuarioDto> listaUsuarioDTO(List<Usuario> usuarioList);

}
