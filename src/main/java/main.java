import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        //Inicializa o Scanner para ler dados digitados pelo usuário
        Scanner scan = new Scanner(System.in);

        //Tenta fazer a conexao com o banco de dados antes de abrir o menu
        try {
            Connection conectar = conexao.conectar();
            System.out.println("Conexao realizada!");
        } catch (SQLException e) {
            //Mostra o erro caso a conexao com o banco falhe
            System.out.println("Falha ao conectar: " + e.getMessage());
        }

        /*
        Int option controla o menu do estoque.
        Enquanto for diferente de 0, o programa continua a rodar em loop.
         */
        int option = -1;

        while (option != 0) {
            //Exibe as opções disponíveis no menu
            System.out.println("\n=====ESTOQUE=====\n" +
                    "- Selecione uma opcao -\n" +
                    "1 - Cadastrar um produto \n" +
                    "2 - Ver estoque\n" +
                    "3 - Remover produto \n" +
                    "4 - Tirar quantidade de produto\n" +
                    "0 - Sair " );

            //Le a opção escolhida pelo usuário
            option = scan.nextInt();

            //Executa uma ação de acordo com a opção escolhida
            switch (option) {
                case 1:
                    //Limpa a quebra de linha que fica depois do nextInt()
                    scan.nextLine();

                    //Recebe o nome do produto
                    System.out.println("Digite o nome do produto: ");
                    String produto = scan.nextLine();

                    //Recebe o preco do produto
                    System.out.println("Digite o preco do produto: ");
                    Double preco = scan.nextDouble();

                    //Recebe a quantidade do produto
                    System.out.println("Digite a quantidade do produto: ");
                    int quantidade = scan.nextInt();

                    //Impede o usuário de inserir preço ou quantidade invalida
                    if (preco >= 1 && quantidade >= 1) {
                        //Cadastra o produto no banco de dados
                        estoque.inserirProduto(produto, preco, quantidade);
                    } else {
                        System.out.println("Quantidade ou preco invalido!");
                    }
                    break;
                case 2:
                    //Busca e exibe os produtos cadastrados no estoque
                    estoque.verEstoque();
                    break;
                case 3:
                    System.out.println("Digite o ID do produto que deseja remover ");
                    int productid = scan.nextInt();
                    if (productid >=1){
                        estoque.removerProduto(productid);
                    } else {
                        System.out.println("Digite um numero maior que 0!");
                    }
                    break;
                case 4:
                    System.out.println("Digite o Id do produto : ");
                    int setId = scan.nextInt();
                    System.out.println("Quanto deseja retirar do estoque? : ");
                    int rqtd = scan.nextInt();
                    if (setId >= 1 && rqtd >= 1) {
                        estoque.retirarQuantidade(setId, rqtd);
                    } else {
                        System.out.println("ID ou quantidade invalida!");
                    }
                    break;
            }
        }
    }
}
