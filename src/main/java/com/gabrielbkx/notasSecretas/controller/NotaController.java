package com.gabrielbkx.notasSecretas.controller;

import com.gabrielbkx.notasSecretas.model.Nota;
import com.gabrielbkx.notasSecretas.model.dto.DadosBuscarNotas;
import com.gabrielbkx.notasSecretas.model.dto.DadosSalvarNotas;
import com.gabrielbkx.notasSecretas.service.NotaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("api/notas")
public class NotaController {

    private final NotaService service;

    public NotaController(NotaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DadosBuscarNotas> salvarNota(@RequestBody DadosSalvarNotas dadosNota) {
        Nota novaNota = service.criarNota(dadosNota.conteudo());

        var uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{token}")
                .buildAndExpand(novaNota.getToken())
                .toUri();

        return ResponseEntity.created(uri).body(new DadosBuscarNotas(novaNota.getToken()));
    }

    @GetMapping("/{token}")
    public ResponseEntity<DadosSalvarNotas> lerNota(@PathVariable String token) {
        var nota = service.lerNota(token);
        return ResponseEntity.ok(new DadosSalvarNotas(nota));
    }

}
