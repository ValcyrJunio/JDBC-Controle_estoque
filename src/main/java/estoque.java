import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class estoque {
    //Método resposável para criar as tabelas caso não exista
    public static void criarTabelas(){
        String sql = """
                CREATE TABLE IF NOT EXISTS produto (
                id INT PRIMARY KEY AUTO_INCREMENT,
                nome VARCHAR(100) NOT NULL,
                preco DECIMAL(10,2) NOT NULL,
                quantidade INT default 0
                )
                """;
        try (
                Connection conectar = conexao.conectar();
                Statement statement = conectar.createStatement();
        ){
            statement.executeUpdate(sql);
            System.out.println("Tabelas verificadas");

        } catch (Exception e) {
            System.out.println("Não foi possível criar a tabela: " + e.getMessage());
        }
    }

    //Método responsável por cadastrar um produto no banco de dados
    public static void inserirProduto(
            String nome,
            double preco,
            int quantidade
    ) {
        //Comando SQL que insere os dados na tabela produto
        String sql = """
                INSERT INTO produto(nome, preco, quantidade)
                VALUES(?, ?, ?)
                """;

        //Abre a conexao e prepara o comando SQL
        try (
                Connection conectar = conexao.conectar();
                PreparedStatement comando = conectar.prepareStatement(sql)
        ) {
            //substitui os pontos de interrogação pelos valores recebidos
            comando.setString(1, nome);
            comando.setDouble(2, preco);
            comando.setInt(3, quantidade);

            //Executa o INSERT no banco de dados
            int linhasAfetadas =  comando.executeUpdate();
            if (linhasAfetadas > 0 ) {
                System.out.println("Produto cadastrado");
            } else {
                System.out.println("ID inválido");
            }

        } catch (Exception e) {
            //Mostra o erro caso o cadastro falhe
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    //Metodo responsavel por listar os produtos cadastrados
    public static void verEstoque() {
        //Comando SQL que busca todos os produtos da tabela
        String sql = """
                SELECT * FROM produto;
                """;

        //Abre a conexao, prepara o comando e executa a consulta
        try (
                Connection conectar = conexao.conectar();
                PreparedStatement comando = conectar.prepareStatement(sql);
                ResultSet resultado = comando.executeQuery()
        ) {
            System.out.println("\n ID - NOME - PRECO - QTD");

            //Percorre cada produto encontrado no banco
            while (resultado.next()) {
                //Pega os valores das colunas da tabela produto
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                double preco = resultado.getDouble("preco");
                int quantidade = resultado.getInt("quantidade");

                //Exibe os dados do produto formatados no console
                System.out.printf("%d - %s | R$ - %.2f | %d%n ",
                        id,
                        nome,
                        preco,
                        quantidade);
            }

        } catch (Exception e) {
            //Interrompe o programa caso aconteça algum erro ao listar
            throw new RuntimeException(e);
        }
    }
    public static void removerProduto(int id){
        String sql = """
                DELETE FROM produto
                WHERE id = ?
                """;
        try(
                Connection conectar = conexao.conectar();
                PreparedStatement comando = conectar.prepareStatement(sql)
                ){
            comando.setInt(1, id);

            int linhasAfetadas =  comando.executeUpdate();
            if (linhasAfetadas > 0 ) {
                System.out.println("Produto removido! ");
            } else {
                System.out.println("ID inválido");
            }


        } catch (Exception e) {
            System.out.println("Erro ao remover produto: " + e.getMessage());
        }
    }
    public static void retirarQuantidade(int id, int quantidade){

        String sql = """
                UPDATE produto
                SET quantidade = quantidade - ?
                WHERE id = ?
                AND quantidade >= ?
                """;
    try(
            Connection conectar = conexao.conectar();
            PreparedStatement comando = conectar.prepareStatement(sql);
            ){
        comando.setInt(1, quantidade);
        comando.setInt(2, id);
        comando.setInt(3, quantidade);

        int linhasAfetadas = comando.executeUpdate();
        if (linhasAfetadas > 0 ) {
            System.out.println("Quantidade retirada! ");
        } else {
            System.out.println("Quantidade ou ID inválido");
        }
        } catch (Exception e) {
        System.out.println("Erro ao retirar quantidade: " + e.getMessage());
    }
    }
    public static void alterarNome(int id, String nome){
        String sql = """
                UPDATE produto
                SET nome = ?
                WHERE id = ?
                """;
    try(
            Connection conectar  = conexao.conectar();
            PreparedStatement comando = conectar.prepareStatement(sql)
            ) {
        comando.setString(1, nome);
        comando.setInt(2, id);

        int linhasAfetadas = comando.executeUpdate();
        if (linhasAfetadas > 0 ){
            System.out.println("Nome alterado com sucesso!");
        }else {
            System.out.println("Erro ao alterar o nome verifique o id");
        }

    } catch (Exception e) {
        System.out.println("Erro ao mudar o nome do produto-  "+e.getMessage());
    }
    }
    public static void alterarPreco(int id, double preco){
        String sql = """
                UPDATE produto
                SET preco = ?
                WHERE id = ?
                """;
        try (
                Connection conectar = conexao.conectar();
                PreparedStatement comando = conectar.prepareStatement(sql)
                ){
            comando.setDouble(1, preco);
            comando.setInt(2, id);

            int linhasAfetadas =  comando.executeUpdate();
            if (linhasAfetadas > 0 ) {
                System.out.println("Preço alterado com sucesso!");
            } else {
                System.out.println("ID inválido");
            }

        } catch (SQLException e) {

            System.out.println("Erro ao alterar preço: " + e.getMessage());
        }
    }
}
