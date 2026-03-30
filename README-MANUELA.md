# 🎓 Sistema de Gerenciamento de Alunos (Refatoração & API REST)

Este projeto consistiu na refatoração completa de uma aplicação legada para uma arquitetura moderna e escalável utilizando **Spring Boot**. O foco principal foi a transição de um "código macarrônico" para uma estrutura organizada, com persistência real e containerização.

## 🚀 Melhorias e Evoluções

### 1. Arquitetura em Camadas
Saímos de um código único e desorganizado para o padrão de responsabilidades:
- **Controller:** Gestão dos endpoints e protocolos HTTP.
- **Service:** Concentra as regras de negócio e validações.
- **Model:** Representação das entidades e mapeamento JPA.
- **Repository:** Interface de comunicação com o banco de dados.

### 2. Persistência & Banco de Dados
- Substituição do armazenamento temporário em ArrayList pelo **PostgreSQL**.
- Implementação do **Spring Data JPA** para facilitar consultas e persistência.
- Monitoramento de dados via **DBeaver**.

### 3. Validações Rigorosas
Implementação de regras de negócio via Bean Validation:
- CPF validado com exatamente 11 dígitos.
- Campos obrigatórios com verificação de "não vazio".

### 4. Containerização com Docker
- Criação de `Dockerfile` otimizado para a aplicação Java.
- Configuração de `docker-compose.yml` para orquestrar a API e o Banco de Dados, garantindo que o ambiente seja idêntico em qualquer máquina.

## 🛠️ Tecnologias Utilizadas
- **Java 21** / **Spring Boot 3**
- **PostgreSQL** (Banco de dados relacional)
- **Docker & Docker Compose** (Infraestrutura)
- **Insomnia** (Testes de integração)
- **DBeaver** (Gestão de DB)

## ⚙️ Como Executar

1. Certifique-se de ter o Docker instalado.
2. Na raiz do projeto, execute o comando:
   ```bash
   docker-compose up -d


## Endpoints (Testados no Insomnia)
- `GET /alunos` - Lista todos os estudantes.

- `POST/alunos` - Cadastra um aluno (Valida CPF e campos obrigatórios).

- `PUT/alunos/{id}` - Atualiza dados por ID.

- `DELETE/alunos/{id}` - Remove um registro.

 A API estará disponível em http://localhost:8080/alunos

### Endpoint de Health Check
Implementado utilizando o **Spring Boot Actuator**. O sistema agora expõe um endpoint que verifica não apenas se a aplicação está "viva", mas se a conexão com o banco de dados **PostgreSQL** está íntegra.

* **URL:** `/actuator/health`
* **Configuração:** O arquivo `application.properties` foi ajustado para exibir detalhes completos do status do banco.
* **Status Esperado:** * `UP`: Aplicação e Banco operacionais.
   * `DOWN`: Falha crítica em algum componente (ex: Banco fora do ar).

### Logs Estruturados (SLF4J)
Substituímos o uso de `System.out.println` pela biblioteca de logs estruturados **SLF4J**. Isso permite monitorar o comportamento do sistema em diferentes níveis de severidade:

* **INFO:** Registra fluxos normais, como tentativas e sucessos de cadastro de alunos.
* **WARN:** Alerta sobre ações sensíveis, como a deleção de registros.
* **ERROR:** Captura falhas críticas, como exceções de banco de dados e erros de validação de CPF.

## Trello do Projeto
https://trello.com/invite/b/69b851861a665b5cc438f7ae/ATTI7b2951bc905fcd31cdb3004d636d83ca2685FF9B/uniesptech-devops
