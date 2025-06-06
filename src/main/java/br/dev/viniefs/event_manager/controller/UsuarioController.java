package br.dev.viniefs.event_manager.controller;

import br.dev.viniefs.event_manager.dto.UsuarioDto;
import br.dev.viniefs.event_manager.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping("/criar")
    public UsuarioDto criarUsuario(@RequestBody UsuarioDto usuarioDto) {
        return service.criarUsuario(usuarioDto);
    }

    @PatchMapping("/atualizar/{id}")
    public UsuarioDto atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto) {
        return service.atualizarUsuario(id, usuarioDto);
    }

    @GetMapping("/listar")
    public List<UsuarioDto> listarUsuarios() {
        return service.listarUsuarios();
    }

    @GetMapping("/listar/{id}")
    public UsuarioDto listarPorId(@PathVariable Long id) {
        return service.listarPorId(id);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        service.deletarUsuario(id);
    }
}
