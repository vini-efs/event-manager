package br.dev.viniefs.event_manager.model;

import br.dev.viniefs.event_manager.model.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "tb_usuários")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;
    private String senha;
    private LocalDate dataNascimento;
    @Enumerated(EnumType.STRING)
    private Perfil tipoPerfil;

    @OneToMany(mappedBy = "organizador")
    @JsonIgnore
    private List<Evento> eventosOrganizador;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Inscricao> inscricoes;
}

