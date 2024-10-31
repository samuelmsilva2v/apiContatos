# API Agenda de Contatos

Este projeto é uma API RESTful desenvolvida com Spring Boot para gerenciar contatos e suas respectivas categorias. A aplicação permite criar, listar, atualizar e excluir contatos e categorias.

### Tecnologias
* Java 21
* Spring Boot
* Maven
* JDBC
* PostgreSQL
* Swagger (OpenAPI) para documentação da API
* Lombok

### Funcionalidades
* __CRUD de Contatos:__ cadastro, consulta e atualização de contatos
```json
{
  "nome": "string",
  "email": "string",
  "telefone": "string",
  "categoria_id": 0
}
```
* __CRUD de Categorias:__ cadastro, consulta e edição de contatos
```json
 {
    "id": 0,
    "nome": "string",
    "contatos":[
      {
        "nome": "string",
        "email": "string",
        "telefone": "string"
      },
      {
        "nome": "string",
        "email": "string",
        "telefone": "string"
      }
    ]
  }
```
* __Relacionamento entre Contatos e Categorias:__ um contato pode pertencer a uma ou mais categorias.
* __Validação de Dados:__ campos validados para assegurar consistência dos dados.

### Endpoints
#### Endpoints de Contatos
| Método | Endpoint          | Descrição                   |
|--------|--------------------|-----------------------------|
| POST   | `/api/contatos`   | Cadastrar um novo contato        |
| GET    | `/api/contatos`   | Listar todos os contatos     |
| GET    | `/api/contatos/{id}` | Consultar um contato por ID |
| PUT    | `/api/contatos/{id}` | Atualizar um contato       |
| DELETE | `/api/contatos/{id}` | Remover um contato         |

#### Endpoints de Categorias
| Método | Endpoint               | Descrição                    |
|--------|-------------------------|------------------------------|
| POST   | `/api/categorias`      | Cadastrar uma nova categoria      |
| GET    | `/api/categorias`      | Listar todas as categorias    |
| GET    | `/api/categorias/{id}` | Consultar uma categoria por ID |
| PUT    | `/api/categorias/{id}` | Atualizar uma categoria       |
| DELETE | `/api/categorias/{id}` | Remover uma categoria         |

### Instalação
1. Clone o repositório:
```bash
   git clone https://github.com/samuelmsilva2v/apiContatos.git
   cd apiContatos
```
2. Instalando as dependências e compilando o projeto com Maven:
```bash
./mvnw clean install
```
3. Executando a aplicação:
```bash
./mvnw spring-boot:run
```
A aplicação vai rodar em http://localhost:8080/swagger-ui/index.html#

### Script para criação do banco de dados no Postgres

```sql
CREATE DATABASE bd_contatos;

CREATE TABLE categoria (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE contato (
    id VARCHAR(255) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    telefone VARCHAR(20),
    categoria_id INT,
    FOREIGN KEY (categoria_id) REFERENCES categoria(id) ON DELETE SET NULL
);
