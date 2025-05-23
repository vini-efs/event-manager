package br.dev.viniefs.event_manager.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_participação")
public class InscricaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataInscricao;
    private Boolean presente;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private EventoModel evento;

    @OneToOne(mappedBy = "inscricao", cascade = CascadeType.ALL)
    private CertificadoModel certificado;

}
