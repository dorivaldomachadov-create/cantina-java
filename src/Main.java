import java.util.Scanner;

public class Main{
    static void main() {
        Scanner sc = new Scanner(System.in);
        Estoque geral = new Estoque();
        Venda v = new Venda();
        int opcao =0;
        GestorDeBancoDeDadosComArquivos j = new GestorDeBancoDeDadosComArquivos();
        j.LerDados(geral);
        try {
        while (opcao!=4) {

                System.out.println("-------------Menu--------------");
                System.out.println("DIGITE: ");
                System.out.println("[1]Cadastrar produto");
                System.out.println("[2]Mostrar estoque");
                System.out.println("[3]Realizar venda");
                System.out.println("[4]Sair");
                opcao = sc.nextInt();

                switch (opcao) {
                    case 1:
                        geral.CadastrarEmStoque(geral.produtos.size());
                        break;
                    case 2:
                        geral.ExibirEstoque();
                        break;
                    case 3:
                        v.SelecionarProdutos(geral);
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("essa opção não existe");
                        break;

                }

        }
        }catch (Exception erro){
            System.out.println("Digite um inteiro");
        }
        j.GuardarDados(geral);
    }
}