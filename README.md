**CST em Análise e Desenvolvimento de Sistemas - Uninter**

**Desenvolvimento Web Back-End (Atividade Prática)**

**Profa. Luciane Kanashiro, Me**

**Aluno: Natan Marques dos Anjos (RU: 5204364)**

**1\. Especificação da API desenvolvida**

**Tecnologias utilizadas**

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- JSON nos endpoints

**Entidades criadas**

Cliente

\- id - Long

\- nome - String

\- clienteDesde - LocalDate

Produto

\- id - Long

\- nome - String

\- preco - BigDecimal

\- estoque - Boolean

Pedido

\- id - Long

\- cliente - Cliente

\- produto - Produto

\- quantidade - Integer

**2\. Endpoints implementados**

**Cliente**

\- POST /api/clientes - cadastrar cliente

\- GET /api/clientes - listar clientes

\- GET /api/clientes/{id} - consultar cliente por ID

\- PUT /api/clientes/{id} - atualizar cliente

\- DELETE /api/clientes/{id} - excluir cliente

**Produto**

\- POST /api/produtos - cadastrar produto

\- GET /api/produtos - listar produtos

\- GET /api/produtos/{id} - consultar produto por ID

\- PUT /api/produtos/{id} - atualizar produto

\- DELETE /api/produtos/{id} - excluir produto

**Pedido**

\- POST /api/pedidos - cadastrar pedido

\- GET /api/pedidos - listar pedidos

\- GET /api/pedidos/{id} - consultar pedido por ID

\- PUT /api/pedidos/{id} - atualizar pedido

\- DELETE /api/pedidos/{id} - excluir pedido