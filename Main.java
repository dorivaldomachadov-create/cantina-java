import cantina.modelo.*;
import cantina.repositorio.*;
import cantina.servico.*;
import cantina.util.Formatador;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProdutoRepositorio produtosRepo = new ProdutoRepositorio();
        PedidoServico pedidoServico = new PedidoServico();
        Scanner leitor = new Scanner(System.in);
        
        int contadorPedidos = 1;

        System.out.println("--- BEM-VINDO AO SISTEMA DE CANTINA ---");
        Pedido pedidoAtual = new Pedido(contadorPedidos);

        while (true) {
            System.out.println("\n=================================");
            System.out.println("1. Cadastrar Novo Produto no Cardápio");
            System.out.println("2. Ver Cardápio");
            System.out.println("3. Adicionar Item ao Pedido");
            System.out.println("4. Finalizar e Ver Total do Pedido");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = leitor.nextInt();

            if (opcao == 1) {
                System.out.println("\n--- CADASTRAR PRODUTO ---");
                System.out.print("Tipo (1 para Comida, 2 para Bebida): ");
                int tipo = leitor.nextInt();
                
                System.out.print("ID do Produto: ");
                int idProd = leitor.nextInt();
                
                leitor.nextLine();
                
                System.out.print("Nome do Produto: ");
                String nome = leitor.nextLine();
                
                System.out.print("Preço (Kz): ");
                double preco = leitor.nextDouble();

                if (tipo == 1) {
                    produtosRepo.salvar(new Comida(idProd, nome, preco));
                    System.out.println("Comida cadastrada com sucesso!");
                } else if (tipo == 2) {
                    produtosRepo.salvar(new Bebida(idProd, nome, preco));
                    System.out.println("Bebida cadastrada com sucesso!");
                } else {
                    System.out.println("Tipo inválido! Produto não cadastrado.");
                }

            } else if (opcao == 2) {
                System.out.println("\n--- CARDÁPIO ---");
                if (produtosRepo.listarTodos().isEmpty()) {
                    System.out.println("Nenhum produto cadastrado ainda. Use a opção 1.");
                } else {
                    for (Produto produto : produtosRepo.listarTodos()) {
                        System.out.println(produto.getId() + " - " + produto.getNome() + " (" + Formatador.formatarMoeda(produto.getPreco()) + ")");
                    }
                }

            } else if (opcao == 3) {
                System.out.println("\n--- FAZER PEDIDO ---");
                System.out.print("Digite o ID do Produto desejado: ");
                int id = leitor.nextInt();
                
                System.out.print("Quantidade: ");
                int quantidade = leitor.nextInt();
                
                Produto produto = produtosRepo.buscarPorId(id);
                if (produto != null) {
                    pedidoAtual.adicionarItem(new ItemPedido(produto, quantidade));
                    System.out.println(quantidade + "x " + produto.getNome() + " adicionado(s) ao pedido #" + pedidoAtual.getId() + "!");
                } else {
                    System.out.println("Produto não encontrado no cardápio!");
                }

            } else if (opcao == 4) {
                double total = pedidoServico.calcularTotal(pedidoAtual);
                System.out.println("\n=================================");
                System.out.println("RESUMO DO PEDIDO #" + pedidoAtual.getId());
                System.out.println("=================================");
                
                if (pedidoAtual.getItens().isEmpty()) {
                    System.out.println("O pedido está vazio.");
                } else {
                    for(ItemPedido item : pedidoAtual.getItens()) {
                        System.out.println(item.getQuantidade() + "x " + item.getProduto().getNome() + " = " + Formatador.formatarMoeda(item.getSubtotal()));
                    }
                    System.out.println("---------------------------------");
                    System.out.println("TOTAL A PAGAR: " + Formatador.formatarMoeda(total));
                    
                    contadorPedidos++;
                    pedidoAtual = new Pedido(contadorPedidos);
                    System.out.println("\n(Sistema pronto para o próximo pedido: #" + contadorPedidos + ")");
                }

            } else if (opcao == 5) {
                System.out.println("Saindo do sistema ... Até logo!");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
        leitor.close();
    }
}