package br.dev.viniefs.event_manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "tb_certificados")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
