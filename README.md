# 🧊🍳 FridgeAI

[![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0-brightgreen?style=for-the-badge&logo=springboot)](https://spring.io/projects/spring-boot)
[![Google Gemini](https://img.shields.io/badge/Google%20Gemini-AI-blue?style=for-the-badge&logo=google-gemini)](https://aistudio.google.com/)
[![LangChain4j](https://img.shields.io/badge/LangChain4j-Framework-blueviolet)](https://github.com/langchain4j/langchain4j)

O **FridgeAI** é uma aplicação Spring Boot inteligente projetada para ajudar na gestão de alimentos e na criação de receitas personalizadas. Utilizando Inteligência Artificial (Google Gemini), o sistema analisa os itens disponíveis na sua geladeira para sugerir pratos criativos e práticos, combatendo o desperdício.

---

## 🚀 Tecnologias e Ferramentas

O projeto utiliza o que há de mais moderno em integração de IA com Java:

* **Linguagem:** Java 21 (LTS)
* **Framework:** Spring Boot 4.0.2
* **Inteligência Artificial:** Google Gemini 1.5 Flash via **LangChain4j**
* **Persistência & ORM:** Spring Data JPA e Hibernate
* **Banco de Dados:** PostgreSQL
* **Migrações de Banco:** Flyway
* **Documentação:** SpringDoc OpenAPI (Swagger UI)
* **Mapeamento:** MapStruct e Lombok
* **Conteinerização:** Docker e Docker Compose

---

## 🛠️ Funcionalidades de IA (O Grande Diferencial)

* **Assistente Chef (IA):** O sistema utiliza o **Gemini 1.5 Flash** configurado com uma persona de Chef de Cozinha.
* **Ferramentas Dinâmicas (Tools):** O assistente de IA tem a capacidade de consultar o banco de dados em tempo real para verificar quais ingredientes estão cadastrados.
* **Receitas Contextuais:** As sugestões de receitas são elaboradas estritamente com base nos itens encontrados na sua dispensa virtual.

### 🛡️ Segurança e Robustez
O projeto foca em integridade de dados e facilidade de integração:
* **Validação de Dados:** Uso de `@Valid` e `@NotNull` para garantir a consistência das entradas.
* **Tratamento Global de Exceções:** Respostas de erro padronizadas.
* **Flyway:** Versionamento seguro do esquema de banco de dados.

---

## 📂 Arquitetura do Projeto

O projeto é estruturado para suportar a integração complexa entre banco de dados e LLMs:

1.  **Controller:** Exposição dos endpoints REST e interação com o assistente.
2.  **Service:** Lógica de negócio e integração com os serviços de IA do LangChain4j.
3.  **Tool:** Definição de ferramentas que a IA pode invocar para realizar ações.
4.  **Config:** Configurações de Beans e chaves de API.

---

## ⚙️ Como Executar o Projeto

### Pré-requisitos
* Docker e Docker Compose instalados.
* JDK 21 ou superior.
* Uma chave de API do **Google Gemini** ([Google AI Studio](https://aistudio.google.com/)).

### Passo a Passo

1. **Clone o repositório:**
```bash
git clone https://github.com/PedroMolon/FridgeAI.git
cd FridgeAI
```

2. **Configure as variáveis de ambiente:**
   Crie um arquivo `.env` na raiz do projeto:
```env
DB_PASSWORD=sua_senha_do_banco
GEMINI_API_KEY=sua_chave_da_api_gemini
```

3. **Inicie os serviços com Docker Compose:**
```bash
docker-compose up -d
```

4. **Execute a aplicação:**
```bash
./mvnw spring-boot:run
```

---

## 📝 Documentação da API (Endpoints Principais)

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/assistant` | Envia uma mensagem para o assistente de IA |
| `GET` | `/foods` | Lista todos os itens na geladeira |
| `POST` | `/foods` | Adiciona um novo alimento |
| `GET` | `/swagger-ui/index.html` | Documentação interativa Swagger |

---

## 👨‍💻 Autor

Desenvolvido com ☕ por **Pedro Molon**.
Conecte-se comigo no [LinkedIn](https://www.linkedin.com/in/pedromolon/) ou veja outros projetos no meu [GitHub](https://github.com/PedroMolon).
