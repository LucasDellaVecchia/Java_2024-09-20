package com.example.agenda.domain.cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCliente(
        @NotBlank
        String nome,
        @NotNull
        int idade,
        @NotBlank
        String endereco,
        @NotBlank
        String email
) {
}
