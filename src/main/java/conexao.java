import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class conexao {
    //URL do banco de dados MySQL que será acessado
    private static final String URL =
            "jdbc:mysql://localhost:3306/";
    private static final String BANCO =
            "estoque";
    //Usuário usado para conectar no banco
    private static final String USUARIO =
            "root";

    //Senha usada para conectar no banco
    private static final String SENHA =
            "Sua_senha";

    public static Connection conectar() throws SQLException {
        //Cria o banco de dados caso não exista
        try (
            Connection conexaoServidor =
                    DriverManager.getConnection(URL,USUARIO,SENHA);
            Statement statement = conexaoServidor.createStatement()){
            statement.executeUpdate(
                    "CREATE DATABASE IF NOT EXISTS "+ BANCO
                );
            }

        String urlBanco = URL + BANCO;
        //Abre e retorna uma conexão com o banco de dados=
        return DriverManager.getConnection(
                urlBanco,
                USUARIO,
                SENHA
        );

    }

}
