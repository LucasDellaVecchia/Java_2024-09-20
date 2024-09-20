package com.example.agenda.domain.cliente;

public record DadosListagemCliente(Long id, String nome, int idade, String endereco, String email) {

    public DadosListagemCliente(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getIdade(), cliente.getEndereco(), cliente.getEmail());
    }

}
