# 📚 API Biblioteca

API REST para gerenciamento de livros de uma biblioteca, construída com **Spring Boot** e **PostgreSQL**, totalmente conteinerizada com **Docker**.

## 🚀 Tecnologias

- Java 21
- Spring Boot 4.1
- Spring Data JPA
- PostgreSQL 18
- H2 (banco em memória para testes)
- Lombok
- Docker / Docker Compose
- Maven

## 📁 Estrutura do projeto

```
api-biblioteca/
├── src/
│   └── main/
│       └── java/com/biblioteca/api_biblioteca/
│           ├── controller/
│           │   └── LivroController.java
│           ├── model/
│           │   └── Livro.java
│           └── repository/
│               └── LivroRepository.java
├── src/main/resources/
│   └── application.properties
├── Dockerfile
├── docker-compose.yml
├── .env
├── pom.xml
└── README.md
```

## ⚙️ Como rodar o projeto

### Pré-requisitos

- Docker e Docker Compose instalados
- (Opcional, pra rodar local sem Docker) Java 21 + Maven + PostgreSQL

### Rodando com Docker (recomendado)

1. Clone o repositório:
```bash
git clone <url-do-repositorio>
cd api-biblioteca
```

2. Copie o arquivo de exemplo de variáveis de ambiente e ajuste as credenciais:
```bash
cp .env.example .env
```

3. Suba os containers:
```bash
docker compose up --build
```

4. A API estará disponível em:
```
http://localhost:8080
```

### Rodando localmente (sem Docker)

1. Suba um PostgreSQL local e crie o banco `biblioteca_db`.
2. Configure as variáveis de ambiente `DB_USER` e `DB_PASSWORD` (ou exporte no terminal).
3. Rode:
```bash
./mvnw spring-boot:run
```

## 📡 Endpoints

| Método | Rota      | Descrição                  |
|--------|-----------|-----------------------------|
| GET    | `/livros` | Lista todos os livros       |
| POST   | `/livros` | Cadastra um novo livro      |

### Exemplo de requisição — POST `/livros`

```json
{
  "titulo": "Dom Casmurro",
  "autor": "Machado de Assis",
  "anoPublicacao": "1899"
}
```

### Exemplo de resposta

```json
[
  {
    "id": 1,
    "titulo": "Dom Casmurro",
    "autor": "Machado de Assis",
    "anoPublicacao": "1899"
  }
]
```

## 🗺️ Roadmap

- [x] CRUD básico de livros (listar e cadastrar)
- [x] Persistência com PostgreSQL
- [x] Conteinerização com Docker e Docker Compose
- [ ] Endpoints de atualizar (`PUT`) e deletar (`DELETE`) livro
- [ ] Buscar livro por ID (`GET /livros/{id}`)
- [ ] Validação de campos (Bean Validation / `@Valid`)
- [ ] Tratamento global de exceções (`@ControllerAdvice`)
- [ ] Paginação e ordenação na listagem
- [ ] Filtro de busca por título/autor
- [ ] Testes unitários e de integração
- [ ] Documentação da API com Swagger/OpenAPI
- [ ] Autenticação e autorização (Spring Security + JWT)
- [ ] Relacionamento com entidade `Usuario` (empréstimos de livros)
- [ ] Deploy em nuvem (Render, Railway ou similar)
- [ ] Pipeline de CI/CD

## 🧪 Testando a API

Com o projeto rodando, use `curl`, [Insomnia](https://insomnia.rest/) ou [Postman](https://www.postman.com/):

```bash
# Listar livros
curl http://localhost:8080/livros

# Cadastrar livro
curl -X POST http://localhost:8080/livros \
  -H "Content-Type: application/json" \
  -d '{"titulo":"O Hobbit","autor":"J.R.R. Tolkien","anoPublicacao":"1937"}'
```

## 📝 Licença

Este projeto está sob livre uso para fins de estudo e portfólio.
