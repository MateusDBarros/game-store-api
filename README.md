# Game Store API

Uma API RESTful desenvolvida com **Spring Boot** para gerenciamento de jogos. O projeto permite operações CRUD (Create, Read, Update, Delete) com categorização baseada em **enums**, validação de dados e tratamento de erros para evitar duplicidades e informações inválidas.

## 🚀 Funcionalidades

- CRUD completo para gerenciar jogos.
- Categorização de jogos utilizando **enums**:
    - FPS
    - Ação
    - Terror
    - Aventura
    - Infantil
- Tratamento de erros para:
    - Dados ausentes (ex.: nome, ano de lançamento, categoria).
    - Tentativas de duplicação de jogos.
- Validações de entrada robustas.

## 🛠️ Tecnologias Utilizadas

- **Java 17**: Linguagem principal do projeto.
- **Spring Boot**: Framework utilizado para construção da API.
- **PostgreSQL**: Banco de dados utilizado.
- **Maven**: Gerenciamento de dependências.
- **JUnit** (futuro): Planejado para testes automatizados.
- **Swagger/OpenAPI** (futuro): Planejado para documentação da API.

## 📄 Endpoints da API

### Jogos
- `GET /games` - Lista todos os jogos.
- `GET /games/{id}` - Busca um jogo por ID.
- `POST /games` - Adiciona um novo jogo.
- `PUT /games/{id}` - Atualiza um jogo existente.
- `DELETE /games/{id}` - Remove um jogo.

### Exemplo de JSON para POST/PUT
```json
{
  "name": "The Legend of Zelda",
  "year": 1986,
  "category": "AVENTURA"
}
```

## 📄 Melhorias Futuras

 - Testes unitários e de integração com JUnit e Mockito.
 - Paginação e filtros nos endpoints GET.
 - Documentação interativa da API com Swagger.
 - Implementação de autenticação com Spring Security.