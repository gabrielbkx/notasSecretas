package com.gabrielbkx.notasSecretas.service;

import com.gabrielbkx.notasSecretas.model.Nota;
import com.gabrielbkx.notasSecretas.repository.NotaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class NotaService {

    private final NotaRepository repository;

    public NotaService(NotaRepository notaRepository) {
        this.repository = notaRepository;
    }

    public Nota criarNota(String conteudo) {

        Nota nota = new Nota();
        nota.setConteudo(conteudo);
        return repository.save(nota);
    }

    @Transactional // Importante para garantir a atomicidade
    public String lerNota(String token) {

        var nota = repository.findByToken(token);

        if (nota.isEmpty()) {
            throw new NoSuchElementException("Nota não encontrada ou já foi lida.");
        }
            excluirNota(token);

            return nota.get().getConteudo();
    }

    @Transactional
    public void excluirNota(String token) {
        repository.deleteByToken(token);
    }
}
