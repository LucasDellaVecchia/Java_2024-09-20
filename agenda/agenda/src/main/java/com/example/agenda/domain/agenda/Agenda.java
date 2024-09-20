package com.example.agenda.domain.agenda;

import com.example.agenda.domain.cliente.Cliente;
import com.example.agenda.domain.robo.Robo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Table(name = "agendas")
@Entity(name = "Agenda")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Agenda {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "robo", referencedColumnName = "id")
    private Robo robo;
    private Date data;
    private Time hora;
    private Boolean ativo;

    public Agenda(DadosCadastroAgenda dados) {
        this.cliente = dados.cliente();
        this.robo = dados.robo();
        this.data = dados.data();
        this.hora = dados.hora();
        this.ativo = true;
    }

    public void alterarDados(DadosAlteraAgenda dados) {

        if (dados.cliente() != null) {
            this.cliente = dados.cliente();
        }
        if (dados.robo() != null) {
            this.robo = dados.robo();
        }
        if (dados.data() != null) {
            this.data = dados.data();
        }
        if (dados.hora() != null) {
            this.hora = dados.hora();
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
