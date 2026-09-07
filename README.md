Projeto entregável desenvolvido pela equipe P2A, a cerca do projeto Lactare.

Tecnologias utilizadas:
- Java 17
- Spring Boot 3.5.14
- Spring Data JPA (Hibernate)
- Spring Web
- Bean Validation (Jakarta Validation)
- Banco de dados H2 (em memória)
- Maven

Para que o projeto rode como intencionado, é necessário primeiro, confirgurar a IDE utilizada. Certifique-se de que possui o plugin do Lombok baixado e siga as configurações abaixo:
- Configure o sdk ms-17 e a language level também 17.
- Na aba de Compiler das configurações do projeto, cheque a caixa de "Build project automatically"
- Dentro da aba de Compiler, da aba Annotation Processors, cheque a caixa de "Enable annotation processing"
- Na ana Advanced Setting, cheque a caixa "Allow auto-make to start even if developed application is currently running"

O projeto utiliza H2 em memória, fazendo com que não seja necessário instalar nenhum banco de dados externo. Os dados são carregados automaticamente ao banco, que é criado na inicialização da aplicação, através do arquivo import.sql
que já vem populado com registros de exemplo para testes. O projeto utiliza a porta 8081, ao invés da porta 8080.

Para documentação interativa do projeto, utilizamos o Swagger. Para acessar a documentação, certifique-se de que aplicação está rodando e acesse a url: http://localhost:8081/swagger-ui/index.html

Como executar a aplicação? 
1. Clone o repositório em sua máquina
2. Siga o passo a passo de configuração acima
3. Execute a classe LactareApiApplication.java em sua IDE
4. Teste se o projeto subiu através do PostMan ou aplicativo similar, ou com o comando curl http://localhost:8081/usuarios

Comandos de teste da aplicação
- Criação de um usuário utilizando POST /usuarios
  {
  "nome": "Fernanda Costa",
  "regiao": "Bahia",
  "ehNutriz": true,
  "telefoneWhatsapp": "+5571999990004",
  "dataCadastro": "2026-08-01"
  }
- Criação de ua pergunta utilizando POST /perguntas
  {
  "textoPergunta": "Posso doar leite tomando remédio para gripe?",
  "categoria": "Requisitos",
  "dataRegistro": "2026-08-05",
  "idUsuario": 1,
  "idSolucao": 2
  }

A API centraliza o tratamento de erros no `GlobalExceptionHandler`, retornando um corpo padronizado:
{
  "timestamp": "2026-09-05T14:30:00Z",
  "status": 404,
  "error": "Recurso não encontrado. ID: 999",
  "path": "/usuarios/999"
}
