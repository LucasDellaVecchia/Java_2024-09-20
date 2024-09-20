package com.example.agenda.domain.robo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "robos")
@Entity(name = "Robo")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Robo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String ip;
    private String endereco;
    private Boolean ativo;


    public Robo(DadosCadastroRobo dados) {
        this.nome = dados.nome();
        this.ip = dados.ip();
        this.endereco = dados.endereco();
        this.ativo = true;
    }

    public void alterarDados(DadosAlterarRobo dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.ip() != null) {
            this.ip = dados.ip();
        }
        if (dados.endereco() != null) {
            this.endereco = dados.endereco();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
