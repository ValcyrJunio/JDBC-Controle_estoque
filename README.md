# JDBC Controle de Estoque

Projeto simples em Java usando JDBC para controlar produtos num banco de dados MySQL.

## Funcionalidades

- Conexão com banco de dados MySQL
- Cadastro de produtos
- Listagem dos produtos cadastrados
- Remoção de produtos pelo ID
- Retirada de quantidade do estoque
- Validação simples para impedir preço, ID e quantidade inválidos

## Projeto em andamento

Este projeto ainda está em desenvolvimento. Atualmente, o sistema funciona pelo consola de videojogos e permite cadastrar, listar, remover produtos e retirar quantidade do estoque.

Próximos passos planejados:

- Adicionar opção para atualizar nome e preço dos produtos
- Melhorar o menu principal
- Tratar entradas invalidas digitadas pelo usuário
- separar melhor as responsabilidades das classes
- Configurar a senha do banco de dados com variáveis de ambiente
- Criar testes para validar as principais funcionalidades

## Tecnologias usadas

- Java
- Maven
- JDBC
- MySQL
- MySQL Connector/J

## Estrutura do projeto

```text
src/main/java/
+-- conexao.java
+-- estoque.java
+-- main.java
```

## Configuração do banco de dados

Antes de executar o projeto, crie o banco de dados e a tabela no MySQL:

```sql
CREATE DATABASE estoque;

USE estoque;

CREATE TABLE produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DOUBLE NOT NULL,
    quantidade INT NOT NULL
);
```

## Configuração da conexão

No arquivo `src/main/java/conexao.java`, ajuste o usuário e a senha do seu MySQL:

```java
private static final String URL = "jdbc:mysql://localhost:3306/estoque";
private static final String USUARIO = "root";
private static final String SENHA = "Sua_senha";
```

Troque `Sua_senha` pela senha usada no seu MySQL local.

## Como executar

1. Clone o repositório:

```bash
git clone https://github.com/ValcyrJunio/JDBC-Controle_estoque.git
```

2. Entre na pasta do projeto:

```bash
cd JDBC-Controle_estoque
```

3. Compile o projeto com Maven:

```bash
mvn compile
```

4. Execute a classe `main` pela sua IDE.

## Dica

Não envie senhas reais para o GitHub. Antes de publicar o projeto, mantenha a senha como exemplo ou use variaveis de ambiente.
