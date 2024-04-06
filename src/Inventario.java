import java.util.LinkedList;
import java.util.List;

public class Inventario {
    private final int limiteDeItens;
    private List<Item> inventario;

    public Inventario(int limiteDeItens) {
        this.limiteDeItens = limiteDeItens;
        // Criamos um inventario vazio
        this.inventario = new LinkedList<>();
    }

    // Método padrao chamado quando imprimimos a classe inventario
    @Override
    public String toString() {
        if (this.inventario.isEmpty()) {
            return "O inventario está vazio!";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Inventario { ")
                .append("Limite inventario: ").append(this.limiteDeItens)
                .append(", Inventario: { ");
            for (Item itemInventario : this.inventario) {
                stringBuilder.append(itemInventario);
            }
            stringBuilder.append(" }").append(" }");
            return stringBuilder.toString();
        }
    }

    public boolean adicionarItem(Item item) {
        return this.inventario.size() < this.limiteDeItens ? this.inventario.add(item) : false;
    }

    public Item acessarItem(String nomeItem) {
        Item itemEncontrado = null;

        for (Item itemInventario : this.inventario) {
            if (itemInventario.getNome().equals(nomeItem)) {
                itemEncontrado = itemInventario;
            }
        }

        return itemEncontrado;
    }

    public void removerItem(String nomeItem) {
        for (Item itemInventario : this.inventario) {
            if (itemInventario.getNome().equals(nomeItem)) {
                this.inventario.remove(itemInventario);
                break;
            }
        }
    }

    public void removerItem(List<String> listaNomesItens) {
        for (Item itemInventario : this.inventario) {
            for (String nomeItem : listaNomesItens) {
                if (itemInventario.getNome().equals(nomeItem)) {
                    this.inventario.remove(itemInventario);
                    break;
                }
            }
        }
    }

    public void listarItens() {
        for (Item itemInventario : this.inventario) {
            System.out.println(itemInventario);
        }
    }

    public int getLimiteDeItens() {
        return this.limiteDeItens;
    }
}
