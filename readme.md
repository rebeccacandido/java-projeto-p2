# 📚 Projeto JAVA - P2

Projeto desenvolvido para a disciplina **Linguagem de Programação I (Java)**, com o objetivo de praticar:

- Criação de projeto estrutura padrão **Spring Boot**
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

- **Java 17+**
- **Spring Boot** (Web, Data JPA)
- **H2 Database** (banco em memória)
- **Maven**
- **Insomnia** (para testes de API)

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

1. **Clonar o repositório:**

   ```bash
   git clone https://github.com/<rebeccacandido>/<projeto-p2-java>.git
   cd <projeto-p2-java>
   ```

2. **Rodar com Maven:**

   ```bash
   mvn spring-boot:run
   ```

3. Ou executar a classe `ProjetoP2JavaApplication` pela IDE.

    A API ficará disponível em:
        http://localhost:8082
---

## 🔌 Como testar a API (Insomnia/Postman)

**Base URL padrão:** `http://localhost:8082`

### Subir a aplicação

- Rodar o projeto Spring Boot (pela IDE ou com `mvn spring-boot:run`).
- Confirmar que a aplicação está de pé chamando, por exemplo, `GET /api/turmas` no Insomnia.

---

### Passo 1 – Criar uma turma

**Endpoint:** `POST /api/turmas`

- **Método:** `POST`
- **URL:** `http://localhost:8082/api/turmas`
- **Body:** JSON
- **Content-Type:** `application/json`

Exemplo de corpo para cadastrar uma turma:

```json
{
  "nome": "8º B",
  "professorNome": "Prof. Fernanda"
}
```

Após enviar, a API deve retornar a turma criada com um `id` gerado automaticamente.

---

### Passo 2 – Listar turmas e anotar o id

**Endpoint:** `GET /api/turmas`

- **Método:** `GET`
- **URL:** `http://localhost:8082/api/turmas`
- **Body:** vazio

A resposta será uma lista de turmas. Anote o campo `id` de uma delas, pois será usado como `turmaId` na etapa de cadastro de aluno.

Exemplo de resposta simplificada:

```json
[
  {
    "id": 1,
    "nome": "8º B",
    "professorNome": "Prof. Fernanda"
  }
]
```

---

### Passo 3 – Criar um aluno ligado a uma turma

**Endpoint:** `POST /api/alunos`

- **Método:** `POST`
- **URL:** `http://localhost:8082/api/alunos`
- **Body:** JSON
- **Content-Type:** `application/json`

O corpo da requisição deve conter o nome do aluno e o `turmaId` obtido no passo anterior:

```json
{
  "nome": "Maria Souza",
  "turmaId": 1
}
```

A API deve retornar o aluno criado, já vinculado à turma.

---

### Passo 4 – Listar perguntas do quiz

**Endpoint:** `GET /api/quiz/perguntas`

- **Método:** `GET`
- **URL:** `http://localhost:8082/api/quiz/perguntas`
- **Body:** vazio

A resposta será uma lista de perguntas com seus respectivos `id`s. Esses `id`s serão usados como `perguntaId` na próxima etapa.

Exemplo de resposta simplificada:

```json
[
  {
    "id": 1,
    "enunciado": "Quanto é 2 + 2?",
    "respostaCorreta": "4"
  },
  {
    "id": 2,
    "enunciado": "Capital da França?",
    "respostaCorreta": "Paris"
  }
]
```

---

### Passo 5 – Registrar respostas do aluno

**Endpoint:** `POST /api/quiz/responder`

Esse método recebe os dados via parâmetros (`@RequestParam`), **não via JSON**.  
Os três parâmetros são:

- `alunoId` – id do aluno criado no passo 3
- `perguntaId` – id da pergunta do passo 4
- `resposta` – resposta enviada pelo aluno (texto)

**Forma mais simples (sem body, tudo na URL)**

No Insomnia:

- **Método:** `POST`
- **URL (exemplo):**

```text
http://localhost:8082/api/quiz/responder?alunoId=1&perguntaId=1&resposta=4
```

- **Body:** vazio

A cada chamada desse endpoint, uma resposta é registrada para o aluno.

> Obs.: também é possível enviar como `x-www-form-urlencoded` (chaves `alunoId`, `perguntaId`, `resposta`), mas **não é JSON**.

---

### Passo 6 – Gerar o diagnóstico do aluno

**Endpoint:** `GET /api/diagnostico/{alunoId}`

- **Método:** `GET`
- **URL (exemplo):**

```text
http://localhost:8082/api/diagnostico/1
```

- **Body:** vazio

A API irá calcular e retornar o diagnóstico do aluno com base nas respostas registradas no passo 5 (por exemplo, desempenho, acertos, etc.).

---

## 🧪 Resumo rápido dos endpoints

- `GET /api/turmas` – lista turmas
- `POST /api/turmas` – cadastra turma (**Body JSON obrigatório**)
- `GET /api/alunos` – lista alunos
- `POST /api/alunos` – cadastra aluno (**Body JSON obrigatório: nome, turmaId**)
- `GET /api/quiz/perguntas` – lista perguntas do quiz
- `POST /api/quiz/responder` – registra respostas do aluno (**sem JSON; usa parâmetros na URL ou form-urlencoded**)
- `GET /api/diagnostico/{alunoId}` – gera diagnóstico do aluno
