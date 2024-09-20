package com.example.agenda.domain.agenda;

import com.example.agenda.domain.cliente.Cliente;
import com.example.agenda.domain.robo.Robo;

import java.sql.Time;
import java.util.Date;

public record DadosListagemAgenda(Long id, Cliente cliente, Robo robo, Date data, Time hora) {

    public DadosListagemAgenda(Agenda agenda) {
        this(agenda.getId(), agenda.getCliente(), agenda.getRobo(), agenda.getData(), agenda.getHora());
    }

}
