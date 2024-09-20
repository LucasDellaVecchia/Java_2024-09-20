package com.example.agenda.domain.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "clientes")
@Entity(name = "Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String endereco;
    private String email;
    private Boolean ativo;

    public Cliente(DadosCadastroCliente dados) {
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.email = dados.email();
        this.endereco = dados.endereco();
        this.ativo = true;
    }


    public void alterarDados(DadosAtualizaCliente dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.idade() != 0) {
            this.idade = dados.idade();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.endereco() != null) {
            this.endereco = dados.endereco();
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
