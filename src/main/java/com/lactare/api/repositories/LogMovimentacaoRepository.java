package com.lactare.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lactare.api.entity.LogMovimentacao;

public interface LogMovimentacaoRepository extends JpaRepository<LogMovimentacao, Long> {
}
