import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class estoque {

    //Metodo responsavel por cadastrar um produto no banco de dados
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
            //Substitui os pontos de interrogacao pelos valores recebidos
            comando.setString(1, nome);
            comando.setDouble(2, preco);
            comando.setInt(3, quantidade);

            //Executa o INSERT no banco de dados
            comando.executeUpdate();

            System.out.println("Produto cadastrado");

        } catch (Exception e) {
            //Mostra o erro caso o cadastro falhe
            System.out.println("Erro ao cadastrar produto: " + e);
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
            //Interrompe o programa caso aconteca algum erro ao listar
            throw new RuntimeException(e);
        }
    }
}
