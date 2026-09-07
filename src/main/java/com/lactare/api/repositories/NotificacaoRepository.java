package com.lactare.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lactare.api.entity.Notificacao;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {
}
