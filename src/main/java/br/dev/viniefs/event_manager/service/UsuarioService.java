package br.dev.viniefs.event_manager.service;


import br.dev.viniefs.event_manager.dto.UsuarioDto;

import br.dev.viniefs.event_manager.exceptions.UsuarioNotFoundException;
import br.dev.viniefs.event_manager.mapstruct.UsuarioMapper;
import br.dev.viniefs.event_manager.mapstruct.UsuarioUpdate;
import br.dev.viniefs.event_manager.model.Usuario;
import br.dev.viniefs.event_manager.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;
    private final UsuarioUpdate update;

    public UsuarioDto criarUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = mapper.toEntity(usuarioDto);
        return mapper.toDto(repository.save(usuario));
    }

    public UsuarioDto atualizarUsuario(Long id, UsuarioDto usuarioDto) {
        Usuario usuarioAtualizado = repository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário não encontrado!"));
        update.atualizacaoParcial(usuarioDto, usuarioAtualizado);
        return mapper.toDto(repository.save(usuarioAtualizado));
    }

    public List<UsuarioDto> listarUsuarios() {
        return mapper.listaUsuarioDTO(repository.findAll());
    }

    public UsuarioDto listarPorId(Long id) {
        Usuario usuarioListar = repository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário não encontrado!"));
        return mapper.toDto(usuarioListar);
    }

    public void deletarUsuario(Long id) {
        Usuario usuarioExistente = repository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário não encontrado!"));
        repository.deleteById(id);
    }
}

