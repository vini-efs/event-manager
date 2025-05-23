package br.dev.viniefs.event_manager.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "tb_certificados")
public class CertificadoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer horas;
    private LocalDateTime dataGeracao;
    private UUID codigoValidacao;
    private String linkArquivo;

    @OneToOne
    @JoinColumn(name = "inscricao_id")
    private InscricaoModel inscricao;
}
