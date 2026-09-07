package com.lactare.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lactare.api.entity.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
}
