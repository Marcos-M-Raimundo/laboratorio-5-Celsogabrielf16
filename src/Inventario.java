import java.util.LinkedList;
import java.util.List;

public class Inventario {
    private final int limiteInventario;
    private List<Item> inventario;

    public Inventario(int limiteInventario) {
        // Criamos um inventario vazio
        this.inventario = new LinkedList<>();
        this.limiteInventario = limiteInventario;
    }

    // Método padrao chamado quando imprimimos a classe inventario
    @Override
    public String toString() {
        if (this.inventario.isEmpty()) {
            return "O inventario está vazio!";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Inventario { ")
                .append("Limite inventario: ").append(this.limiteInventario)
                .append(", Inventario: {");
            for (Item itemInventario : this.inventario) {
                stringBuilder.append(itemInventario);
            }
            stringBuilder.append(" }").append(" }");
            return stringBuilder.toString();
        }
    }

    public boolean adicionarItem(Item item) {
        return this.inventario.size() < this.limiteInventario ? this.inventario.add(item) : false;
    }

    public void removerItem(String nomeItem) {
        for (Item itemInventario : this.inventario) {
            if (itemInventario.getNome().equals(nomeItem)) {
                this.inventario.remove(itemInventario);
                break;
            }
        }
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

    public void listarInventario() {
        for (Item itemInventario : this.inventario) {
            System.out.println(itemInventario);
        }
    }

    public int getLimiteInventario() {
        return this.limiteInventario;
    }
}
