# JDBC Controle de Estoque

Projeto simples em Java usando JDBC para controlar produtos num banco de dados MySQL pelo consola de videojogos.

## Funcionalidades

- Conexão com banco de dados MySQL
- Criação automática do banco de dados `estoque`, caso ele não exista
- Verificacao/criacao automática da tabela `produto` ao iniciar o sistema
- Cadastro de produtos com nome, preço e quantidade
- Listagem dos produtos cadastrados
- Remoção de produtos pelo ID
- Retirada de quantidade do estoque
- Atualização do nome do produto
- Atualização do preço do produto
- Validação simples para impedir preço, ID e quantidade inválidos

## Projeto em andamento

Este projeto continua em desenvolvimento. Atualmente, o sistema funciona pelo consola de videojogos e permite cadastrar, listar, remover, atualizar nome, atualizar preço e retirar quantidade dos produtos no estoque.

Próximos passos planejados:

- Melhorar o tratamento de entradas invalidas digitadas pelo usuário
- Melhorar as mensagens exibidas no menu
- separar melhor as responsabilidades das classes
- Configurar usuário e senha do banco de dados com variáveis de ambiente
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

## Banco de dados

O projeto usa o banco de dados MySQL chamado `estoque`.

Ao iniciar o programa, a classe `conexao` conecta primeiro no servidor MySQL usando a URL base:

```java
jdbc:mysql://localhost:3306/
```

Depois disso, ela cria o banco automaticamente caso ele ainda não exista:

```sql
CREATE DATABASE IF NOT EXISTS estoque;
```

Em seguida, o sistema conecta no banco `estoque` e a classe `estoque` verifica/cria a tabela `produto`.

Modelo esperado da tabela:

```sql
CREATE TABLE IF NOT EXISTS produto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    quantidade INT DEFAULT 0
);
```

## Configuração da conexão

No arquivo `src/main/java/conexao.java`, ajuste o usuario e a senha do seu MySQL:

```java
private static final String URL = "jdbc:mysql://localhost:3306/";
private static final String BANCO = "estoque";
private static final String USUARIO = "root";
private static final String SENHA = "Sua_Senha";
```

Troque `Sua_Senha` pela senha usada no seu MySQL local.

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

## Menu do sistema

```text
1 - Cadastrar um produto
2 - Ver estoque
3 - Remover produto
4 - Tirar quantidade de produto
5 - Atualizar nome do produto
6 - Atualizar preco do produto
0 - Sair
```

## Observação

Não envie senhas reais para o GitHub. Antes de publicar o projeto, mantenha a senha como exemplo ou use variaveis de ambiente.
