package com.example.agenda.domain.robo;

public record DadosListagemRobo(Long id, String nome, String ip, String endereco) {

    public DadosListagemRobo(Robo robo) {
        this(robo.getId(), robo.getNome(), robo.getIp(), robo.getEndereco());
    }

}
