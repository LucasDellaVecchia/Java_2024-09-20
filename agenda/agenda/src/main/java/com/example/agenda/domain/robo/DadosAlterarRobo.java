package com.example.agenda.domain.robo;

import jakarta.validation.constraints.NotNull;

public record DadosAlterarRobo(
        @NotNull
        Long id,
        String nome,
        String ip,
        String endereco
) {
}
