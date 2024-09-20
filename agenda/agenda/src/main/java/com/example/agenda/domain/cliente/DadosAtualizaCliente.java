package com.example.agenda.domain.cliente;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaCliente(
        @NotNull
        Long id,
        String nome,
        int idade,
        String endereco,
        String email
) {
}
