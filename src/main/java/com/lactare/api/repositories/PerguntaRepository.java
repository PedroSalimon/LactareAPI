package com.lactare.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lactare.api.entity.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {
}
