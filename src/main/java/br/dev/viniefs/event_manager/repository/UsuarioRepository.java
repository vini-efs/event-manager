package br.dev.viniefs.event_manager.repository;

import br.dev.viniefs.event_manager.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
