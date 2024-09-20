package com.example.agenda.controller;

import com.example.agenda.domain.robo.*;
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
@RequestMapping("/robo")
public class RoboController {

    @Autowired
    private RoboRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroRobo dados, UriComponentsBuilder uriBuilder) {
        var robo = new Robo(dados);
        repository.save(robo);

        var uri = uriBuilder.path("/robos/{id}").buildAndExpand(robo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemRobo>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var pagina = repository.findAll(paginacao).map(DadosListagemRobo::new);
        return ResponseEntity.ok(pagina);
    }

    @PutMapping
    @Transactional
    public ResponseEntity alterar(@RequestBody @Valid DadosAlterarRobo dados) {
        var robo = repository.getReferenceById(dados.id());
        robo.alterarDados(dados);

        return ResponseEntity.ok(new DadosListagemRobo(robo));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var robo = repository.getReferenceById(id);
        robo.excluir();

        return ResponseEntity.noContent().build();
    }


}
