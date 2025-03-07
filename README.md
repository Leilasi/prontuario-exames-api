# 🚀 Gestão de Prontuários Clínico API

Este projeto é um microserviço desenvolvido em **Java com Spring Boot**, responsável pelo gerenciamento de prontuários de exames em uma clínica médica.

---

## 📌 Funcionalidades

- ✅ Cadastro e gerenciamento de prontuários de exames.
- ✅ Validação e persistência de dados.
- ✅ Persistência de dados utilizando banco **PostgreSQL**.
- ✅ API REST documentada com **Swagger**.
- ✅ Arquitetura baseada em **Camadas**.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.4.3**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**
- **Swagger / SpringDoc (OpenAPI)**
- **Maven**
- **Docker**

---

## 📄 Documentação da API

Após rodar o projeto, acesse a documentação interativa pelo Swagger:

http://localhost:8080/swagger-ui.html

Link do Deploy: https://prontuario-exames-api.onrender.com/swagger-ui/index.html#/

---

## 📦 Como rodar o projeto localmente

### Pré-requisitos:
- Git
- Java 17+
- Maven
- PostgreSQL

### Passo a passo:

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/prontuario-exames-api.git

# Acesse o diretório do projeto
cd prontuario-exames-api

# Compile o projeto
mvn clean install

# Rode a aplicação
mvn spring-boot:run

🗂️ Endpoints principais
Método	Rota	Descrição
POST/api/prontuario-exame/adicionarNovoProntuario - Adicionar um novo prontuário
GET/api/prontuario-exame/chamarProximoPaciente - 	Chamar próximo paciente
GET/api/prontuario-exame/buscarTodosProntuarios - Buscar todos os prontuários
GET/api/prontuario-exame/buscarProntuario	Buscar - prontuário por ID
GET/api/prontuario-exame/buscarProntuarioPorCpf	- Buscar prontuário por CPF

🔍 Exemplo de Requisição (JSON)

POST /api/exames/salvar
json

{
  "paciente": "João Silva",
  "tipoExame": "Hemograma",
  "dataExame": "2023-10-01",
  "resultado": "Normal"
}
✅ Resposta de sucesso:


json

{
  "mensagem": "Exame cadastrado com sucesso",
  "id": 1
}


Contribuições são bem-vindas! Sinta-se à vontade para abrir um pull request ou relatar problemas na aba de issues.

Feito com ❤️ por [Leila Fernanda da Silva]  [Estudante da Engenharia da Computação Univesp] 
