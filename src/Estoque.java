import java.util.ArrayList;
import java.util.Scanner;
public class Estoque extends Produto {
    Scanner sc = new Scanner(System.in);
    ArrayList<Produto> produtos = new ArrayList<>();
    int num;


    public void CadastrarEmStoque(int cont){
        try {
            System.out.println("Digite o numero de produtos que deseja cadastrar ou 0 para sair");
            num = sc.nextInt();
            for (int i = cont; i < num + cont; i++) {
                System.out.println("Cadastre os produto");
                produtos.add(new Produto());
                produtos.get(i).Cadartrar();
            }
        }catch (Exception erro){
            System.out.println("digite um inteiro");
        }
    }
    public void ExibirEstoque(){
        for(Produto pro : produtos){
            pro.ExibirInfoEstoque();
        }
    }
    boolean teste = false;
    public boolean VerificarID(int ide, int tamanho){
        for(int d = 0; d<2; d++){
            if (d == ide){
                teste = true;
            }
        }
        if (!teste){
            System.out.println("Esse ID não existe");
        }
        return teste;
    }

}
