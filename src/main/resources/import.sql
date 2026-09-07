insert into tb_usuario (nome, regiao, eh_nutriz, telefone_whatsapp, data_cadastro) values ('Maria Silva', 'São Paulo', true, '+5511999990001', '2026-06-01')
insert into tb_usuario (nome, regiao, eh_nutriz, telefone_whatsapp, data_cadastro) values ('Ana Souza', 'Rio de Janeiro', true, '+5521999990002', '2026-06-05')
insert into tb_usuario (nome, regiao, eh_nutriz, telefone_whatsapp, data_cadastro) values ('Carlos Pereira', 'Minas Gerais', false, '+5531999990003', '2026-06-10')

insert into tb_solucao_conhecida (titulo, descricao_resposta, link_site, categoria) values ('Como funciona a doação de leite', 'Explica o passo a passo para se tornar uma doadora de leite materno.', 'https://lactare.org.br/doacao', 'Doação')
insert into tb_solucao_conhecida (titulo, descricao_resposta, link_site, categoria) values ('Requisitos para ser doadora', 'Lista os requisitos de saúde e cuidados necessários para a doação.', 'https://lactare.org.br/requisitos', 'Requisitos')
insert into tb_solucao_conhecida (titulo, descricao_resposta, link_site, categoria) values ('Onde encontrar um posto de coleta', 'Mostra os postos de coleta e bancos de leite mais próximos da nutriz.', 'https://lactare.org.br/postos', 'Coleta')

insert into tb_pergunta (texto_pergunta, categoria, data_registro, id_usuario, id_solucao) values ('Como faço para doar meu leite?', 'Doação', '2026-07-01', 1, 1)
insert into tb_pergunta (texto_pergunta, categoria, data_registro, id_usuario, id_solucao) values ('Quais são os requisitos para doar?', 'Requisitos', '2026-07-02', 2, 2)
insert into tb_pergunta (texto_pergunta, categoria, data_registro, id_usuario, id_solucao) values ('Ainda tenho dúvidas sobre o processo', 'Doação', '2026-07-03', 3, null)

insert into tb_notificacao (tipo, mensagem, data_envio, status_envio, id_usuario) values ('Checkup', 'Olá! Já pensou em fazer mais uma doação este mês?', '2026-07-10', true, 1)
insert into tb_notificacao (tipo, mensagem, data_envio, status_envio, id_usuario) values ('Lembrete', 'Não esqueça de atualizar seus dados de contato.', '2026-07-12', false, 2)
insert into tb_notificacao (tipo, mensagem, data_envio, status_envio, id_usuario) values ('Checkup', 'Sentimos sua falta! Vamos conversar?', '2026-07-15', true, 3)

insert into tb_avaliacao (nota, comentario, data_avaliacao, id_usuario) values (9, 'Atendimento rápido e claro', '2026-07-05', 1)
insert into tb_avaliacao (nota, comentario, data_avaliacao, id_usuario) values (7, 'Poderia ter mais opções de horário', '2026-07-06', 2)
insert into tb_avaliacao (nota, comentario, data_avaliacao, id_usuario) values (10, null, '2026-07-07', 3)

insert into tb_contrato_suporte (tipo_contrato, data_inicio, data_fim, status, id_usuario) values ('Padrão', '2026-01-01', null, 'Ativo', 1)
insert into tb_contrato_suporte (tipo_contrato, data_inicio, data_fim, status, id_usuario) values ('Premium', '2025-11-15', '2026-11-15', 'Ativo', 2)
insert into tb_contrato_suporte (tipo_contrato, data_inicio, data_fim, status, id_usuario) values ('Padrão', '2026-03-01', '2026-06-01', 'Encerrado', 3)

insert into tb_log_movimentacao (acao, origem, data_hora, id_usuario) values ('Usuário cadastrado', 'Chatbot', '2026-06-01 10:00:00', 1)
insert into tb_log_movimentacao (acao, origem, data_hora, id_usuario) values ('Consulta de indicadores realizada', 'BI', '2026-07-01 14:30:00', null)
insert into tb_log_movimentacao (acao, origem, data_hora, id_usuario) values ('Notificação enviada', 'Chatbot', '2026-07-10 09:00:00', 1)

insert into tb_indicador_desempenho (nome_indicador, valor, periodo_referencia, regiao) values ('Tempo médio de resposta (min)', 2.5, '2026-06', 'São Paulo')
insert into tb_indicador_desempenho (nome_indicador, valor, periodo_referencia, regiao) values ('Taxa de satisfação', 8.7, '2026-06', 'Rio de Janeiro')
insert into tb_indicador_desempenho (nome_indicador, valor, periodo_referencia, regiao) values ('Volume de doações coletadas (L)', 350.0, '2026-06', 'Minas Gerais')
