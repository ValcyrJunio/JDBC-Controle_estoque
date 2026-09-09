import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
    //URL do banco de dados MySQL que será acessado
    private static final String URL =
            "jdbc:mysql://localhost:3306/estoque";

    //Usuário usado para conectar no banco
    private static final String USUARIO =
            "root";

    //Senha usada para conectar no banco
    private static final String SENHA =
            "Sua_senha";

    public static Connection conectar() throws SQLException {
        //Abre e retorna uma conexão com o banco de dados
        return DriverManager.getConnection(
                URL,
                USUARIO,
                SENHA
        );
    }
}
