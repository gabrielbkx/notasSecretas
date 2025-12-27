package com.gabrielbkx.notasSecretas.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "notas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String conteudo;

    @Column(unique = true)
    private String token = UUID.randomUUID().toString();

    LocalDateTime dataCriacao;

}
