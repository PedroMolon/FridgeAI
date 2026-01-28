# FridgeAI 🧊🍳

O **FridgeAI** é uma aplicação Spring Boot inteligente projetada para ajudar na gestão de alimentos e na criação de receitas personalizadas. Utilizando Inteligência Artificial (Google Gemini), o sistema analisa os itens disponíveis na sua geladeira (armazenados em um banco de dados) para sugerir pratos criativos e práticos, evitando o desperdício.

## 🚀 Tecnologias Utilizadas

- **Java 21** & **Spring Boot 4.0.2**
- **LangChain4j**: Integração fluida com modelos de linguagem (LLMs).
- **Google Gemini API**: O cérebro por trás das sugestões de receitas.
- **Spring Data JPA**: Abstração de persistência de dados.
- **PostgreSQL**: Banco de dados relacional.
- **Flyway**: Gerenciamento de migrações de banco de dados.
- **SpringDoc OpenAPI (Swagger)**: Documentação interativa da API.
- **MapStruct**: Mapeamento eficiente entre Entidades e DTOs.
- **Lombok**: Redução de código boilerplate.
- **Docker & Docker Compose**: Facilitando a configuração do ambiente de desenvolvimento.

## 🧠 Funcionalidades de IA

A aplicação utiliza o **Gemini 2.5 Flash** (via LangChain4j) com uma configuração de "Chef de Cozinha". 
- **Ferramentas Dinâmicas (Tools)**: O assistente de IA tem a capacidade de consultar o banco de dados em tempo real para verificar quais ingredientes estão cadastrados.
- **Receitas Contextuais**: As sugestões de receitas são elaboradas estritamente com base nos itens encontrados na sua dispensa virtual.

## 🛠️ Configuração do Projeto

### Pré-requisitos
- Docker e Docker Compose instalados.
- Uma chave de API do Google Gemini (obtida no [Google AI Studio](https://aistudio.google.com/)).

### Instalação

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/FridgeAI.git
   cd FridgeAI
   ```

2. Configure as variáveis de ambiente:
   Crie um arquivo `.env` na raiz do projeto com as seguintes chaves:
   ```env
   DB_PASSWORD=sua_senha_do_banco
   GEMINI_API_KEY=sua_chave_da_api_gemini
   ```

3. Inicie o banco de dados com Docker:
   ```bash
   docker-compose up -d
   ```

4. Execute a aplicação:
   ```bash
   ./mvnw spring-boot:run
   ```

## 🔌 Endpoints Principais

### Alimentos (`/foods`)
- `GET /foods`: Lista todos os itens na geladeira.
- `GET /foods/{id}`: Detalhes de um item específico.
- `POST /foods`: Adiciona um novo alimento.
- `PUT /foods/{id}`: Atualiza informações de um alimento.
- `DELETE /foods/{id}`: Remove um item.

### Assistente de IA (`/assistant`)
- `POST /assistant`: Envia uma mensagem para o assistente.
  - **Exemplo de Corpo**: `"Sugira uma receita para o jantar hoje."`
  - **Resposta**: O assistente consultará o banco, verá o que você tem e retornará uma receita detalhada.

## 📖 Documentação da API (Swagger)

A API possui documentação interativa que pode ser acessada através do Swagger UI. Com a aplicação rodando, acesse:

- **Swagger UI**: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- **OpenAPI Spec (JSON)**: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

## 📂 Estrutura de Pastas

- `src/main/java/.../config`: Configurações de Beans e Integração com Gemini.
- `src/main/java/.../controller`: Exposição dos endpoints REST.
- `src/main/java/.../model`: Entidades JPA e Enums.
- `src/main/java/.../service`: Lógica de negócio e Serviços de IA.
- `src/main/java/.../tool`: Definição de ferramentas que a IA pode utilizar.
- `src/main/resources/db/migration`: Scripts SQL do Flyway.

---
Desenvolvido por [Pedro Molon](https://github.com/pedromolon).
