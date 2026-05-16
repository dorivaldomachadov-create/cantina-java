import java.util.Scanner;
public class Venda extends Estoque {
    Scanner sc = new Scanner(System.in);
    int idproduto = 0;
    int quant;
    double precoTotal = 0.0;

    public void SelecionarProdutos(Estoque e){
         do {
            System.out.println("Digite o id do produto e 0 quando terminar a seleção");
            idproduto = sc.nextInt();
             if(idproduto == 0){

             }else if (VerificarID(idproduto-1, e.produtos.size())){
                e.produtos.get(idproduto-1).ExibirInfoEstoque();
                System.out.println("Digite a quantidade: ");
                quant = sc.nextInt();
                e.produtos.get(idproduto-1).ReduduzirQuatidade(quant);
                precoTotal+=(e.produtos.get(idproduto-1).getPreco()*quant);
            }
        }while (idproduto != 0);
        System.out.printf("Preço total = %.2f ",precoTotal);
    }

}
