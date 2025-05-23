package br.dev.viniefs.event_manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_eventos")
public class EventoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String local;
    private Integer vagas;

    @ManyToOne
    @JoinColumn(name = "organizador_id")
    private UsuarioModel organizador;

    @OneToMany(mappedBy = "evento")
    @JsonIgnore
    private List<InscricaoModel> inscritos;
}
