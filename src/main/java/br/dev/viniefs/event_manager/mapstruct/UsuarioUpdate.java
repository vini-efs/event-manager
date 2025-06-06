package br.dev.viniefs.event_manager.mapstruct;

import br.dev.viniefs.event_manager.dto.UsuarioDto;
import br.dev.viniefs.event_manager.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UsuarioUpdate {

    Usuario atualizacaoParcial(UsuarioDto usuarioDto, @MappingTarget Usuario usuario);
}
