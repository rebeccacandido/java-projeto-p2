# 📚 Projeto JAVA - P2 

Projeto desenvolvido para a disciplina **Linguagem de Programação I (Java)**, com o objetivo de praticar:

- Criação de projeto padrão **Spring Boot**
- Organização em camadas (Controller / Service / Repository / Model)
- Consumo de API via **Insomnia**
- Modelagem de entidades e regras de negócio básicas

O sistema simula um **ambiente escolar**, permitindo:

- Cadastro de **Turmas**
- Cadastro de **Alunos** (vinculados a turmas)
- Aplicação de um **Quiz**
- Geração de um **Diagnóstico** por aluno com base no desempenho

---

## 🧱 Tecnologias utilizadas

- Java 17+
- Spring Boot (Web, Data JPA)
- H2 Database (banco em memória)
- Maven
- Insomnia (para testes de API)

---

## 🗂 Estrutura básica

Pacote base: `com.aurellia.projeto_p2_java`

- `controller` – Endpoints REST
- `service` – Regras de negócio
- `repository` – Persistência com Spring Data JPA
- `model` – Entidades e DTOs

Entidades principais: `Turma`, `Aluno`, `Quiz`, `Resposta`, `Diagnostico`.

---

## 🚀 Como rodar o projeto

1. Clonar o repositório:

   ```bash
   git clone https://github.com/<seu-usuario>/java-projeto-p2.git
   cd java-projeto-p2

2. Rodar com Maven:

   ```bash
    mvn spring-boot:run
    
3. Ou executar a classe ProjetoP2JavaApplication pela IDE.

    A API ficará disponível em:
   http://localhost:8082

---

🔗 Endpoints Principais
        
        Turmas:

        GET /api/turmas – lista turmas
        POST /api/turmas – cadastra turma

        Alunos:

        GET /api/alunos – lista alunos
        POST /api/alunos – cadastra aluno (JSON com nome e turmaId)

        Quiz:

        GET /api/quiz/perguntas – lista perguntas
        POST /api/quiz/responder – registra respostas do aluno

        Diagnóstico:
    GET /api/diagnostico/{alunoId} – gera diagnóstico do aluno