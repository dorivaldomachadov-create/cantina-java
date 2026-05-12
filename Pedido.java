package cantina.modelo;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private List<ItemPedido> itens;

    public Pedido(int id) {
        this.id = id;
        this.itens = new ArrayList<>();
    }

    
    public int getId() {
        return id;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void adicionarItem(ItemPedido item) {
        this.itens.add(item);
    }
}
