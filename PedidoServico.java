package cantina.servico;
import cantina.modelo.Pedido;
import cantina.modelo.ItemPedido;

public class PedidoServico {
    public double calcularTotal(Pedido pedido) {
        double total = 0;
       
        for (ItemPedido item : pedido.getItens()) {
            total += item.getSubtotal();
        }
        return total;
    }
}
