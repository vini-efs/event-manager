package br.dev.viniefs.event_manager.controller;

import br.dev.viniefs.event_manager.dto.UsuarioDto;
import br.dev.viniefs.event_manager.exceptions.UsuarioNotFoundException;
import br.dev.viniefs.event_manager.model.Usuario;
import br.dev.viniefs.event_manager.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping("/criar")
    public ResponseEntity<UsuarioDto> criarUsuario(@Valid @RequestBody UsuarioDto usuarioDto) {
        service.criarUsuario(usuarioDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDto);
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<UsuarioDto> atualizarUsuario(@Valid @PathVariable Long id, @RequestBody UsuarioDto usuarioDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.atualizarUsuario(id, usuarioDto));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDto>> listarUsuarios() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listarUsuarios());
    }

    @GetMapping("/listar/{email}")
    public ResponseEntity<UsuarioDto> buscarPorEmail(@PathVariable String email) {
        UsuarioDto usuarioDto = service.buscarPorEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioDto);
    }

    @DeleteMapping("/deletar/{email}")
    public ResponseEntity<String> deletarUsuario(@PathVariable String email) {
        service.deletarUsuario(email);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário com email: " + email + " deletado com sucesso!");
    }
}
