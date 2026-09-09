# JDBC Controle de Estoque

Projeto simples em Java usando JDBC para controlar produtos num banco de dados MySQL pelo consola de videojogos.

## Funcionalidades

- Conexão com banco de dados MySQL
- Criação automática do banco de dados `estoque`, caso ele não exista
- Verificacao/criacao automática da tabela de produtos ao iniciar o sistema
- Cadastro de produtos
- Listagem dos produtos cadastrados
- Remoção de produtos pelo ID
- Retirada de quantidade do estoque
- Validação simples para impedir preço, ID e quantidade inválidos

## Projeto em andamento

Este projeto ainda está em desenvolvimento. Atualmente, o sistema funciona pelo consola de videojogos e permite cadastrar, listar, remover produtos e retirar quantidade do estoque.

Próximos passos planejados:

- Adicionar opção para atualizar nome e preço dos produtos
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

Ao iniciar o programa, a classe `conexao` tenta criar o banco automaticamente caso ele ainda não exista. Depois disso, a classe `estoque` verifica/cria a tabela de produtos.

Modelo esperado da tabela:

```sql
CREATE TABLE produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    quantidade INT NOT NULL
);
```

## Configuração da conexão

No arquivo `src/main/java/conexao.java`, ajuste o usuário e a senha do seu MySQL:

```java
private static final String URL = "jdbc:mysql://localhost:3306/";
private static final String BANCO = "estoque";
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
