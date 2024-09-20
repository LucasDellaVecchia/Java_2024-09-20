package com.example.agenda.domain.robo;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroRobo(
        @NotBlank
        String nome,
        @NotBlank
        String ip,
        @NotBlank
        String endereco
) {
}
