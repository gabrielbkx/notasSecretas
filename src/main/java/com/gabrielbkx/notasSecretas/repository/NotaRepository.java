package com.gabrielbkx.notasSecretas.repository;

import com.gabrielbkx.notasSecretas.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotaRepository extends JpaRepository<Nota, Long> {

    Optional<Nota> findByToken(String nota);

    void deleteByToken(String token);
}
