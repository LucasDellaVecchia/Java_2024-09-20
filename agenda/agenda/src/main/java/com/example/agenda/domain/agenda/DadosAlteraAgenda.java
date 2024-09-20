package com.example.agenda.domain.agenda;

import com.example.agenda.domain.cliente.Cliente;
import com.example.agenda.domain.robo.Robo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Time;
import java.util.Date;

public record DadosAlteraAgenda(

        @NotNull
        Long id,
        Cliente cliente,
        Robo robo,
        Date data,
        Time hora

) {

}
