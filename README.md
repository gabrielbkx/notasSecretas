# 💣 Nota Segura (Self-Destruct Notes)

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.0-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)

> **"Esta mensagem se autodestruirá em 5 segundos..."** - bom, na verdade, ela se autodestrói imediatamente após a leitura! 🕵️‍♂️

## 📖 Sobre o Projeto

O **Nota Segura** é uma aplicação Fullstack desenvolvida para compartilhar informações sensíveis (como senhas ou tokens) de forma segura e efêmera.

A lógica principal é baseada no conceito de **Leitura Destrutiva**: assim que o link da nota é acessado pela primeira vez, o backend recupera o conteúdo e **apaga o registro do banco de dados na mesma transação**. Se o link for acessado novamente, a aplicação retorna um erro 404, garantindo que a informação não existe mais.

## 🚀 Tecnologias Utilizadas

* **Backend:** Java 17, Spring Boot 3, Spring Data JPA.
* **Banco de Dados:** H2 Database (Em memória, para rapidez e testes), PostgresSQL.
* **Frontend:** HTML5, CSS3 (Dark/Cyberpunk Theme), JavaScript (Fetch API).
* **Ferramentas:** Maven, Lombok.

## ⚙️ Arquitetura e Design

O projeto segue uma arquitetura em camadas simplificada para microsserviços:

* **Controller:** Gerencia os endpoints REST e DTOs (Records).
* **Service:** Contém a regra de negócio crítica (buscar -> salvar na memória -> deletar do banco -> retornar).
* **Repository:** Interface com o Banco de Dados.
* **Segurança:** Uso de UUIDs aleatórios para gerar links não-previsíveis.

## 🔌 Documentação da API

### 1. Criar uma Nota
Gera um link único para compartilhar.

* **URL:** `/api/notas`
* **Método:** `POST`
* **Body (JSON):**
    ```json
    {
      "conteudo": "Minha senha secreta 123"
    }
    ```
* **Resposta (201 Created):**
    ```json
    {
      "token": "a1b2-c3d4-e5f6..."
    }
    ```

### 2. Ler (e Destruir) uma Nota
Recupera o conteúdo e o remove permanentemente do banco.

* **URL:** `/api/notas/{token}`
* **Método:** `GET`
* **Resposta (200 OK):**
    ```json
    {
      "conteudo": "Minha senha secreta 123"
    }
    ```
* **Resposta (404 Not Found):** Caso a nota já tenha sido lida ou não exista.

## 🛠️ Como Rodar o Projeto

1.  Clone o repositório.
2.  Abra o projeto na sua IDE favorita (IntelliJ/Eclipse/VS Code).
3.  Execute a classe `NotasApplication.java`.
4.  Acesse `http://localhost:8080` no seu navegador.

---
Desenvolvido para fins de estudo sobre transações atômicas.
