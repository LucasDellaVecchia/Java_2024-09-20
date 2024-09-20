package com.example.agenda.controller;

import com.example.agenda.domain.agenda.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private AgendaRepository repository;

    @GetMapping
    public ResponseEntity<Page<DadosListagemAgenda>> listar (@PageableDefault(size = 10)Pageable paginacao) {
        var pagina = repository.findAll(paginacao).map(DadosListagemAgenda::new);
        return ResponseEntity.ok(pagina);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAgenda dados, UriComponentsBuilder uriBuilder) {
        var agenda = new Agenda(dados);
        repository.save(agenda);

        var uri = uriBuilder.path("/agenda/{id}").buildAndExpand(agenda.getId()).toUri();

        return ResponseEntity.ok(uri);
    }

    @PutMapping
    @Transactional
    public ResponseEntity alterar(@RequestBody @Valid DadosAlteraAgenda dados) {
        var agenda = repository.getReferenceById(dados.id());
        agenda.alterarDados(dados);

        return ResponseEntity.ok(new DadosListagemAgenda(agenda));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var agenda = repository.getReferenceById(id);
        agenda.excluir();

        return ResponseEntity.noContent().build();
    }

}
