package br.dev.viniefs.event_manager.dto;

import br.dev.viniefs.event_manager.model.Evento;
import br.dev.viniefs.event_manager.model.Inscricao;
import br.dev.viniefs.event_manager.model.enums.Perfil;

import java.time.LocalDate;
import java.util.List;

public record UsuarioDto(String nome,
                         String email,
                         String senha,
                         LocalDate dataNascimento,
                         Perfil tipoPerfil,
                         List<Evento> eventosOrganizador,
                         List<Inscricao> inscricoes) {

}
